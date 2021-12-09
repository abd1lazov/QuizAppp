package space.abdilazov.quizappp.ui.fragments.historyFragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.abdilazov.quizappp.databinding.ListHistoryBinding
import space.abdilazov.quizappp.local.model.RoomResult

class QuestionAdapter(private val questions: ArrayList<RoomResult>): RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    private lateinit var binding: ListHistoryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        binding = ListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {
        holder.onBind(questions[position])
    }

    fun addQuestions(list: ArrayList<RoomResult>) {
        questions.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ListHistoryBinding = ListHistoryBinding.bind(itemView)

        fun onBind(roomResult: RoomResult) {
            "Correct answers:".plus(roomResult.correct_questions.toString())
                .plus("/" + roomResult.total_amount.toString())
                .also { binding.tvCorrectResult.text = it }
            "Difficulty:".plus(roomResult.difficulty).also { binding.tvDifficulty.text = it }
        }
    }
}
