package com.example.quizapp.model

data class QuizResponse(
    val response_code: Int, // 0
    val results: List<Result>
) {
    data class Result(
        val category: String,
        val correct_answer: String,
        val difficulty: String,
        val incorrect_answers: ArrayList<String>,
        val question: String,
        val type: String
    ) {
        val incorrectAnswerWithCorrectAnswer: ArrayList<String>
            get() {
                incorrectAnswerWithCorrectAnswer.addAll(incorrect_answers)
                incorrectAnswerWithCorrectAnswer.add(correct_answer)
                incorrectAnswerWithCorrectAnswer.shuffle()
                return incorrectAnswerWithCorrectAnswer
            }
    }
}