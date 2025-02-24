package com.ebookfrenzy.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import static java.lang.Integer.toBinaryString;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.graphics.Color;
import android.os.Bundle;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;

import android.widget.TextView;
import android.widget.TableLayout;

import android.text.TextUtils;


public class ActivityB extends AppCompatActivity {
    public boolean g = true;
    public Integer N = 1;
    public String a = "2";
    private EditText editText1;
    private EditText linear;
    private Integer[] hodnoty = new Integer[10];
    private String[] koal = new String[10];
    private float[] shap = new float[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        String qString = extras.getString("qString");

        final TextView textView = findViewById(R.id.textView1);
        textView.setText(qString);
////////////////////////////

        Button button4=findViewById(R.id.button4);
        Button button7=findViewById(R.id.button7);

        button4.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View view) {
                        //     TextView status=findViewById(R.id.button9);

                        click4(view);
//                    button9.setText("OK");
                    }
                }


        );

        button7.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View view) {
                        //     TextView status=findViewById(R.id.button9);

                        click7(view);
//                    button9.setText("OK");
                    }
                }


        );

    }




    public void answerQuestion(View view) {
        finish();
    }





    @Override
    public void finish() {
        Intent data = new Intent();

        EditText editText1 = findViewById(R.id.editText1);

        String returnString = editText1.getText().toString();
        data.putExtra("returnData", returnString);

        setResult(RESULT_OK, data);
        super.finish();
    }

    public boolean iswinning(Integer J, int ii) {
        return true;

    }

    public Integer fact(Integer f) {
        if (f == 0) return 1;
        else return f * fact((Integer) (f - 1));
    }

    //T pocetHracu

    //  public Integer[] S = new Integer[toBinaryString(N - 1).length()];

    public boolean areDisjoint(Integer I,Integer J) {
        int pocetHracu= toBinaryString(N-1).length();

        String StringPadded1=stf(toBinaryString(I),pocetHracu- toBinaryString(I).length());
        String StringPadded2=stf(toBinaryString(J),pocetHracu- toBinaryString(J).length());

        Integer[] koal1= stringToArray(StringPadded1);
        Integer[] koal2= stringToArray(StringPadded2);


        for(int i=0;i<pocetHracu;i++) {
            if (koal1[i]==1 & koal2[i]==1) {
                return false;
            }
        }
        return true;

    }


    public Integer union(Integer I,Integer J) {
        int pocetHracu= toBinaryString(N-1).length();

        String StringPadded1=stf(toBinaryString(I),pocetHracu- toBinaryString(I).length());
        String StringPadded2=stf(toBinaryString(J),pocetHracu- toBinaryString(J).length());
        String StringPaddedVysl=stf(toBinaryString(0),pocetHracu-1);


        Integer[] koal1= stringToArray(StringPadded1);
        Integer[] koal2= stringToArray(StringPadded2);
        Integer[] koalVysl=stringToArray(StringPaddedVysl);

        Integer vysl=0;

        for(int i=0;i<pocetHracu;i++) {
//            koalVysl[i]=koal1[i]+koal2[i];
            vysl+=power(pocetHracu-1-i)*(koal1[i]+koal2[i]);


        }

//         vysl=4*(koal1[0]+koal2[0])+2*(koal1[1]+koal2[1])+(koal1[2]+koal2[2]);
        return vysl;

    }


    public Integer power(Integer p) {
        if(p==0) {
            return 1;
        }
        return 2*power(p-1);

    }

    public float K1=0, K2=0, K3=0, K4, K5;

    public boolean isSA(float[] vyhryKoalici) {
        for(Integer I=0;I<N;I++) {
            for(Integer J=0;J<N;J++) {
                if(areDisjoint(I,J)) {
                    if (vyhryKoalici[union(I,J)]<vyhryKoalici[I]+vyhryKoalici[J]) {
                        K1=union(I,J);K2=vyhryKoalici[I];K3=vyhryKoalici[J];
                        return false;
                    }

                }
            }
        }

        return true;
    }




    public Integer[] stringToArray(String binary) {
        Integer[] arrayOfPLayers=new Integer[binary.length()];
        for(int i=0;i<binary.length();i++) {
            arrayOfPLayers[i]=Integer.parseInt("" + binary.charAt(i));

        }
        return arrayOfPLayers;
    }

    //N je pocet koalici
    public void click5(View view) {

        int pocetHracu= toBinaryString(N-1).length();
        Integer[][] koalice=new Integer[N][pocetHracu];
        Integer[][] koalice2=new Integer[N][pocetHracu];
        Integer[][] koalice3=new Integer[N][pocetHracu];



        for (Integer ith=0;ith<N;ith++) {
            for(Integer T=0;T<pocetHracu;T++) {
                String StringPadded=stf(toBinaryString(ith),pocetHracu- toBinaryString(ith).length());
                koalice[ith][T]=stringToArray(StringPadded)[T];
                koalice2[ith][T]=stringToArray(StringPadded)[T];
                koalice3[ith][T]=stringToArray(StringPadded)[T];
            }
        }
        float[] shap=new float[pocetHracu];
        float[] vyhryKoalici = new float[N];
        Integer[] isSwing=new Integer[pocetHracu];

        for (int i=0; i<N;i++) {
            editText1 = (EditText) findViewById(330+i);
            String a=editText1.getText().toString();
            float f1 = Float.parseFloat(a);
            vyhryKoalici[i]=f1;
        }

        Integer[] kolikJeSwingu=  new Integer[pocetHracu];




        String S="";

        String kde="j";

        Integer jth;
        for (int p = 0; p < pocetHracu; p++) {
            isSwing[p] =0;
            kolikJeSwingu[p]=N;
        }

//        Integer swingove2=pocetHracu*N;
        Integer bool=1;
        Integer canBanzhaf=1;

        for(Integer contr=0;contr<N;contr++)
        {
            if(vyhryKoalici[contr]!=0 && vyhryKoalici[contr]!=1) {
                canBanzhaf=0;
            }
        }
        for(Integer T=0;T<pocetHracu;T++) {
            for (Integer ith = 0; ith < N; ith++) {

                bool = 1;

//vyhryKoalici[ith];
//musis najit jth<N pro ktere koalice3[jth]=S-ith
                if ((koalice[ith][T] == 1) && (vyhryKoalici[ith]==1)) {
                    koalice3[ith][T] = 0;
                    for (jth = 0; jth < N; jth++) {
                        for (Integer k = 0; k < pocetHracu; k++)
                        {
                            //if (k != T && koalice[ith][k] != koalice3[jth][k]) {
                            if ((k != T) && (koalice[ith][k] != koalice3[jth][k])) {
                                bool = 0;
                                //   swingove2--;
                                kde+="\nk"+k.toString()+"T"+T.toString()+">";
                            }
                        }
                        kde+="\njth"+jth.toString()+"ith"+ith.toString()+"T"+T.toString();
//(vyhryKoalici[jth]
                        if ((vyhryKoalici[jth]==0) && (bool == 1)) {
                            isSwing[T]++;
                        }
                        bool=1;
                    }
                    koalice3[ith][T]=1;
                    bool=1;
                }

            }
        }



//kolikJeSwingu(Integer TmaSwing, Integer pocetHracu, Integer pocetKoalici,
//                                   Integer[][] koal, Integer[] koalicePriKtereJeSwing, float[] vyhryKoal)

        for (Integer ith = 0; ith < N; ith++) {
            for(Integer T=0;T<pocetHracu;T++) {
//isSwingBool(Integer kteraKoalice, Integer TmaSwing, Integer pocetHracu, Integer pocetKoalici,
//                               Integer[][] koal, Integer[] koalicePriKtereJeSwing, float[] vyhryKoal) {

                //   kolikJeSwingu[T]+=kolikJeSwingu(T, pocetHracu, N,
                //          koalice, koalice[ith],vyhryKoalici);


                if (koalice[ith][T] == 1) {
                    koalice2[ith][T] = 0;
                    for (jth = 0; jth < N; jth++) {
                        bool = 1;
                        for (int k = 0; k < pocetHracu; k++) {
                            if (k != T && koalice[ith][k] != koalice2[jth][k]) {
                                bool = 0;
                            }
                        }

                        int bool2=0;
                        koalice2[ith][T] = 1;

                        if (vyhryKoalici[ith] == 1 && vyhryKoalici[jth] == 0) {
                            for (int k = 0; k < pocetHracu; k++) {
                                if (koalice[ith][k] != koalice2[jth][k]) {
                                    bool2++;
                                }
                            }

                            //    if(bool2==1) {
                            //       isSwing[T]++;
                            //   }

                        }
                        koalice2[ith][T] = 1;
                        Integer t = 0;
                        for (int p = 0; p < pocetHracu; p++) {
                            t += koalice[ith][p];
                        }
                        // Integer[] isSwing=new Integer[pocetHracu];

                        if (bool == 1) {
                            shap[T] += (float) ((float) fact(t - 1) * fact(pocetHracu - t) / (float) (fact(pocetHracu)) * (float) (vyhryKoalici[ith] - vyhryKoalici[jth]));
                        }
                    }
                }

            }
        }


        S+="here";
        String T2="";
        T2+="banzhaf";

        Integer swingove=0;
        Integer totWin=0;
        Integer totLos=0;




        for(int p=0;p<pocetHracu;p++) {
            swingove+=isSwing[p];
        }

        for(int i=0;i<N;i++) {
            if(vyhryKoalici[i]==1) {
                totWin++;
            }

            if(vyhryKoalici[i]==0) {
                totLos++;
            }
        }


        String strPokus="";
        String strPokusColWin="";
        String strPokusColLos="";


        if(canBanzhaf==1) {
            strPokus = "banzhaf ";
            strPokusColWin="coleman winning ";
            strPokusColLos="coleman loosing ";

        } else {
            strPokus="banzhaf err ";
            strPokusColWin="coleman winning err ";
            strPokusColLos="coleman loosing err ";

        }

        float[] banzh=new float[pocetHracu];
        float[] colemanWin=new float[pocetHracu];
        float[] colemanLos=new float[pocetHracu];

        for(int p=0;p<pocetHracu;p++)
        {
            banzh[p]=(float) isSwing[p]/(float) swingove;
            colemanWin[p]=(float) isSwing[p]/(float) totWin;
            colemanLos[p]=(float) isSwing[p]/(float) totLos;
        }


        String strPokus2="shap ";

        for(int i=0;i<pocetHracu;i++) {
            //   S+=(" "+String.valueOf(shap[i]));
            strPokus2+=String.format("%.2f ",shap[i]);
            strPokus+=String.format("%.2f ",banzh[i]);
            strPokusColWin+=String.format("%.2f ",colemanWin[i]);
            strPokusColLos+=String.format("%.2f ",colemanLos[i]);
        }


        // tv6.setText(strPokus2+"\n"+strPokus+"\nswing"+isSwing[0]+"swingPrvni:"+isSwing[1]+"\nH"+swingove);
        TextView tv6 = (TextView) findViewById(R.id.tvMarque);
        //     tv6.setSingleLine(true);
        tv6.setMarqueeRepeatLimit(-1);
        tv6.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tv6.setSelected(true);

        String SA;
        if(isSA(vyhryKoalici)) {
            SA="";
        }
        else {
            SA="here superadditivity fails "+(int) K1+" "+K2+" "+K3;
        }

        tv6.setText(strPokus2+"\n"+strPokus+"\n"+strPokusColWin+"\n"+strPokusColLos+"\n"+"number of winning "+totWin+"\n"+"number of loosing "+totLos+"\nis super additve "+isSA(vyhryKoalici)+"\n"+SA);


        TextView tv7 = (TextView) findViewById(R.id.tvMarque2);
        tv7.setSingleLine(true);
        tv7.setMarqueeRepeatLimit(-1);
        tv7.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tv7.setSelected(true);
//        tv7.setText("         * *            *          * *           *           *  *            *           ");

//        tv7.setText(Html.fromHtml("        * *            *          * *           <b><p style=color:yellow;>*</p></b>           *  *            *           "));

//        tv7.setText(Html.fromHtml("**<p style=color:green;>  *&nbsp;T*</p>\n<ul><li>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p style=color:green;>*</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p style=color:red;>*</p>*  *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;           </li></ul>"));

//        tv7.setText(Html.fromHtml("**<p style=color:green>  *&nbsp;T*</p>\n<ul><li>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p style=color:green;>*</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p style=color:red;>*</p>*  *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;           </li></ul>"));
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(Html.fromHtml("**<p style=color:green>  *&nbsp;**</p>\n<ul><li>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p style=color:green;>*</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p style=color:red;>*</p>*  *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;           </li></ul>"));
        int blinkTextIndex = 6;
        ssb.setSpan(new FCS(tv7, new int[] {Color.RED, Color.YELLOW}), blinkTextIndex, blinkTextIndex + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv7.setText(ssb);

        //  String html = "<html><body><p>Hello world</p></body></html>";
        //    String baseUrl = "https://example.com/";

//        WebView mWebView;
        //      mWebView.loadDataWithBaseURL(baseUrl, html, "text/html", null, baseUrl);

//tv6.setText("11bbbb"+"bDDDDDDDjjjjjjjjjjppppppppppppppDDbbbbbbbbbb");
//        TextView textView=(TextView)findViewById(R.id.text_test);
     /*   tv6.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tv6.setSingleLine(true);
        tv6.setMarqueeRepeatLimit(-1);
        tv6.setFocusableInTouchMode(true);
        tv6.setFocusable(true);

*/

    /*    TextView txt = new TextView(this);
        txt.setText("This is the infinite marquee");
        txt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        txt.setSingleLine(true);
        txt.setMarqueeRepeatLimit(-1);
        txt.setSelected(true);
      */

    }

    public void click4(View view) {
        //

        if (g) {

            linear = (EditText) findViewById(R.id.simpleEditText);
            if (N == 1) {
                linear.setText("1");
            }

            String a = linear.getText().toString();
            N = Integer.parseInt(a);
            N++;
            linear.setText(N.toString());


        }
    }
    public void click7(View view) {
        if (g) {

            //
            linear = (EditText) findViewById(R.id.simpleEditText);
            if (N == 0 || N == 1) {
                linear.setText("1");
            }

            String a = linear.getText().toString();
            N = Integer.parseInt(a);
            if (N > 1) N--;
            linear.setText(N.toString());


        }
    }

    public  String stf(String a,Integer l) {
        if(l==0) { return a; }
        l--;
        return stf("0"+a,l);

    }
    public void click2(View view) {
        if (g) {
            g = false;

            String col1;
            String col2;
            //  String playerChanged;

            TableLayout tl = (TableLayout) findViewById(R.id.tableLayout1);

            EditText editText = (EditText) findViewById(R.id.simpleEditText);


            TableRow row = new TableRow(this);
            TextView tv = new TextView(this);
            TextView c = new TextView(this);

            //EditText etUserInfoNewValue = (EditText)findViewById(R.id.simpleEditText);
            //  a = editText.getText().toString();

            //  tv.setId(202);


            tv.setText("This is text");
//
            tl.addView(row);

            row.addView(tv);

            int sf = toBinaryString(N - 1).length();
            for (int x = 0; x < N; x++) {
0d",(
                String jl = toBinaryString(x);
                String jl2 = stf(jl, sf - jl.length());
//koal[x]=jl2;
                col1 = "(" + x + ")" + jl2;
                // col1 = "(" + x + ")"+Integer.toBinaryString(x);
                col2 = "1";

                //col3 = "(" + x + ") Column 3";
                //col4 = "(" + x + ") Column 4";

                TableRow newRow = new TableRow(this);

                TextView column1 = new TextView(this);
                TextView column2 = new TextView(this);
                EditText editText1 = new EditText(this);

                editText1.setId(330 + x);
                // String stringAnswer = editText1.getText().toString();

                TextView column3 = new TextView(this);
                // TextView column4 = new TextView(this);
                editText1.setText("0        ");
                column1.setText(col1);
                column1.setText(col1);
                column2.setText(col2);
                //column3.setText(col3);
                //column4.setText(col4);

                // column1.setText(stringAnswer);

                newRow.addView(column1);
                newRow.addView(editText1);


                newRow.addView(column3);
                // newRow.addView(column4);

                tl.addView(newRow, new TableLayout.LayoutParams());
            }

        }
    }

}



class FCS extends ForegroundColorSpan implements TimeAnimator.TimeListener {

    private TextView tv;
    private int[] colors;
    private int color;
    TimeAnimator animator;
    ArgbEvaluator evaluator;

    public FCS(TextView tv, int[] colors) {
        super(colors[0]);
        this.tv = tv;
        this.colors = colors;
        animator = new TimeAnimator();
        animator.setTimeListener(this);
        evaluator = new ArgbEvaluator();
        animator.start();
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(color);
    }

    @Override
    public void onTimeUpdate(TimeAnimator animation, long totalTime, long deltaTime) {
        float sin = (float) (Math.sin(Math.PI * totalTime / 400f));
        float fraction = sin * sin;
//            float fraction = (float) (-Math.cos(2*Math.PI * totalTime / 1000f) + 1) / 2f;
        color = (int) evaluator.evaluate(fraction, colors[0], colors[1]);
        tv.invalidate();
        if (totalTime < -1) {
            animator.end();
        }
    }

}