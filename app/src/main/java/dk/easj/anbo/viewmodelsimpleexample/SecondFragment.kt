package dk.easj.anbo.viewmodelsimpleexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dk.easj.anbo.viewmodelsimpleexample.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    // https://developer.android.com/topic/libraries/architecture/viewmodel
    private val viewModel: PersonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        viewModel.name.observe(viewLifecycleOwner)
        { name -> binding.textviewName.text = name }

        viewModel.age.observe(viewLifecycleOwner)
        { age -> binding.textviewAge.text = age.toString() }

        viewModel.address.observe(viewLifecycleOwner)
        { address -> binding.textviewAddress.text = address}
         */

        viewModel.Person.observe(viewLifecycleOwner) { person ->
            binding.textviewName.text = "Hello " + person.name
            binding.textviewAge.text = person.age.toString() + " years old"
            binding.textviewAddress.text = "Your address is " + person.address
        }

        binding.buttonSecond.setOnClickListener {
            //findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}