package test.com.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import test.com.viewmodel.databinding.FragmentSenderBinding

class MessageSenderFragment:Fragment() {
    private val model:ShareViewModel by lazy {
        ViewModelProvider(requireActivity(),
            object : ViewModelProvider.Factory {
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
    ): View? {
        val binding:FragmentSenderBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sender, container, false
        )
        binding.button.setOnClickListener {
            //model.sendMessage("ViewModel TEST")
            shareModel.sendMessage("shareModel TEST")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}