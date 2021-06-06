package test.com.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import test.com.viewmodel.databinding.FragmentReceiverBinding

class MessageReceiverFragment:Fragment() {
    private val model by lazy {
        ViewModelProvider(requireActivity(), object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ShareViewModel() as T
            }
        }).get(ShareViewModel::class.java)
    }

    private val shareModel by activityViewModels<ShareViewModel> {
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T
                = ShareViewModel() as T
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding:FragmentReceiverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_receiver, container, false)

//        model.message.observe(viewLifecycleOwner, Observer {
//            binding.textViewReceiver.text = it
//        })

        shareModel.message.observe(viewLifecycleOwner, Observer {
            binding.textViewReceiver.text = it
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}