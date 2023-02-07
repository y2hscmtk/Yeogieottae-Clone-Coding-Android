//import android.app.Dialog
//import android.content.Context
//import com.example.myapplication.R
//
//object CustomDialogMaker {
//    fun getDialog(
//        context: Context,
//        title: String,
//        message: String,
//        submitCaption: String,
//        cancelCaption: String,
//        target: CustomDialogListener
//    ) {
//        val dialog = Dialog(context, R.style.FullWindowDialog)
//        val dialogBinding = DialogFullActivityBinding.inflate(dialog.layoutInflater)
//        dialog.setContentView(dialogBinding.root)
//
//        dialogBinding.titleTextView.text = title
//        dialogBinding.messageTextView.text = message
//        dialogBinding.submitButton.text = submitCaption
//        dialogBinding.cancelButton.text = cancelCaption
//
//        dialogBinding.submitButton.setOnClickListener {
//            target.onClickSubmitButton()
//            dialog.dismiss()
//        }
//
//        dialogBinding.cancelButton.setOnClickListener {
//            target.onClickCancelButton()
//            dialog.dismiss()
//        }
//
//        dialog.show()
//    }
//}