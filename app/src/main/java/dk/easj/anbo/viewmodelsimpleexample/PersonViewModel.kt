package dk.easj.anbo.viewmodelsimpleexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {
    /*
    val name: MutableLiveData<String> = MutableLiveData()
    val age: MutableLiveData<Int> = MutableLiveData()
    val address: MutableLiveData<String> = MutableLiveData()
    */

    val Person: MutableLiveData<Person> = MutableLiveData()
}