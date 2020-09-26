package com.demo.hw_1__19_09_20;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView2);

        View.OnClickListener buttonListener = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                input = editText.getText().toString();

                try {
                    String[] coefficients = input.split("\\s*[a-z0-9]*\\s*=\\s*|,");
                    double[] nums = new double[3];
                    for (int i = 0, j = 0; i < coefficients.length; i++) {
                        coefficients[i] = coefficients[i].trim();
                        if (coefficients[i].length() > 0) {
                            nums[j] = Double.parseDouble(coefficients[i]);
                            j++;
                        }
                    }

                    double a, b, c;
                    a = nums[0];
                    b = nums[1];
                    c = nums[2];

                    SquareEquasion squareEquasion = new SquareEquasion(a, b, c);
                    Double[] roots = squareEquasion.getRoots();

                    if (roots[0] == null) {
                        textView.setText("Данное уравнение не имеет действительных корней.");
                    } else if (Math.abs(roots[0] - roots[1]) < 0.0001) {
                        textView.setText("Данное уравнение имеет единственный действительный корень:\n\r\n\rx1 = " +
                                String.format("%.3f", roots[0]));
                    } else {
                        textView.setText("Данное уравнение имеет 2 действительных корня:\n\r\n\rx1 = " +
                                String.format("%.3f", roots[0]) + "\n\rx2 = " + String.format("%.3f", roots[1]));
                    }
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    textView.setText("Ошибка. Всего должно быть введено 3 числа. " +
                            "Дробная часть от целой отделяется точкой. " +
                            "Между буквой коэффициента и числом должен стоять пробел");
                }
            }
        };
        button.setOnClickListener(buttonListener);
    }
}