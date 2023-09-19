package dk.easj.anbo.viewmodelsimpleexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import dk.easj.anbo.viewmodelsimpleexample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    // https://developer.android.com/topic/libraries/architecture/viewmodel
    private val viewModel: PersonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGreet.setOnClickListener {
            val name = binding.editTextName.text.trim().toString()
            if (name.isEmpty()) {
                binding.editTextName.error = "No name"
                return@setOnClickListener
            }
            val ageStr = binding.editTextAge.text.trim().toString()
            if (ageStr.isEmpty()) {
                binding.editTextAge.error = "No age"
                return@setOnClickListener
            }
            val address = binding.editTextAddress.text.trim().toString()
            if (address.isEmpty()) {
                binding.editTextAddress.error = "No address"
                return@setOnClickListener
            }

            val person = Person(name, ageStr.toInt(), address)
            viewModel.Person.value = person

            //viewModel.name.value = name
            viewModel.Person.value?.name = name

            //viewModel.age.value = ageStr.toInt()
            viewModel.Person.value?.age = ageStr.toInt()

            //viewModel.address.value = address
            viewModel.Person.value?.name = address

        }

        /*
        viewModel.name.observe(viewLifecycleOwner) { name ->
            binding.textviewName.text = "Hello $name"
        }

        viewModel.age.observe(viewLifecycleOwner) { age ->
            binding.textviewAge.text = "$age years old"
        }

        viewModel.address.observe(viewLifecycleOwner) {address ->
            binding.textviewAddress.text = "Your address is called $address"
        }
         */

        viewModel.Person.observe(viewLifecycleOwner) { person ->
            binding.textviewName.text = "Hello " + person.name
            binding.textviewAge.text = person.age.toString() + " years old"
            binding.textviewAddress.text = "Your address is " + person.address
        }
        binding.buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}