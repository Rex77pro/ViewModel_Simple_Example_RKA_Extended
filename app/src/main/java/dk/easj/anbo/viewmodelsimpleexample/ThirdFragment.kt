package dk.easj.anbo.viewmodelsimpleexample

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dk.easj.anbo.viewmodelsimpleexample.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null

    private val binding get() = _binding!!

    private val viewModel: PersonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.Person.observe(viewLifecycleOwner) { person ->
            binding.textviewName.text = "Hello " + person.name
            binding.textviewAge.text = person.age.toString() + " years old"
            binding.textviewAddress.text = "Your address is " + person.address
        }

        binding.buttonReturn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}