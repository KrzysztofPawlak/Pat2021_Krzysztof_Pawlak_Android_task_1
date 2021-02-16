package com.pawlak.krzysztof.calculator.calculators

import android.os.AsyncTask
import com.pawlak.krzysztof.calculator.MainActivity
import com.pawlak.krzysztof.calculator.R
import java.lang.ref.WeakReference

class FibonacciAsyncCalculator(context: MainActivity) : CalculableUnary {

    private var weakReference: WeakReference<MainActivity> = WeakReference(context)
    private var task: CalcAsyncTask = CalcAsyncTask(context)

    override fun calculate(input: Int): Int {
        if (task.status == AsyncTask.Status.RUNNING) {
            task.cancel(true)
        }
        task = CalcAsyncTask(weakReference.get()!!)
        task.execute(input)
        return 0
    }

    override fun getMaxInput(): Int {
        return task.calculator.getMaxInput()
    }

    companion object {
        class CalcAsyncTask internal constructor(context: MainActivity) :
                AsyncTask<Int, Void, Int>() {

            private val weakReference: WeakReference<MainActivity> = WeakReference(context)
            var calculator: FibonacciCalculator  = FibonacciCalculator()

            override fun doInBackground(vararg params: Int?): Int {
                val activity = weakReference.get()
                if (activity != null && !activity.isFinishing) {
                    activity.runOnUiThread {
                        activity.setResult(activity.getString(R.string.text_processing))
                    }
                }
                return calculator.calculate(params[0]!!)
            }

            override fun onPostExecute(result: Int?) {
                val activity = weakReference.get()
                if (activity == null || activity.isFinishing) return
                activity.setResult(result.toString())
            }
        }
    }
}