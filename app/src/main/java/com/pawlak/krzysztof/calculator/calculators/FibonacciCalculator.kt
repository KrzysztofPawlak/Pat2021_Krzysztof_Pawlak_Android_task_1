package com.pawlak.krzysztof.calculator.calculators

import android.os.AsyncTask
import com.pawlak.krzysztof.calculator.MainActivity
import com.pawlak.krzysztof.calculator.R
import java.lang.Exception
import java.lang.ref.WeakReference

class FibonacciCalculator(context: MainActivity) : CalculableUnary {

    private var weakReference: WeakReference<MainActivity> = WeakReference(context)
    private var task: CalcAsyncTask = CalcAsyncTask(context)
    private val maxNNumberThatCanBeStoredInInt = 46

    override fun calculate(input: Int): Int {
        if (task.status == AsyncTask.Status.RUNNING) {
            task.cancel(true)
        }
        task = CalcAsyncTask(weakReference.get()!!)
        task.execute(input)
        return 0
    }

    override fun getMaxInput(): Int {
        return maxNNumberThatCanBeStoredInInt
    }

    companion object {
        class CalcAsyncTask internal constructor(context: MainActivity) :
                AsyncTask<Int, Void, Int>() {

            private val weakReference: WeakReference<MainActivity> = WeakReference(context)

            override fun doInBackground(vararg params: Int?): Int {
                val activity = weakReference.get()
                if (activity != null && !activity.isFinishing) {
                    activity.runOnUiThread {
                        activity.setResult(activity.getString(R.string.text_processing))
                    }
                }
                val firstElement = 0
                val secondElement = 1
                return calc(params[0], firstElement, secondElement)
            }

            override fun onPostExecute(result: Int?) {
                val activity = weakReference.get()
                if (activity == null || activity.isFinishing) return
                activity.setResult(result.toString())
            }

            private tailrec fun calc(input: Int?, previous: Int, last: Int): Int {
                try {
                    if (input == 0) return previous
                    if (isCancelled) {
                        throw Exception()
                    }
                } catch (e: Exception) {
                    return 0
                }
                return calc(input?.minus(1), last, previous + last)
            }
        }
    }
}