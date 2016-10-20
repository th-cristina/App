package com.example.senai.app;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    Thread tarefa;
    Handler h;

    Button btnJogar,btnLogin,btnMestreTabuada,btnAdicao,btnSubtracao,btnJogarLogin;
    Button btnJogoMemoria,btnVoltar,btnFase1,btnFase2,btnVoltarTabuada,btnDivisao;
    Button btnVoltar1,btnVoltar2,btnRanking,btnVoltarRanking,btnMultiplicacao;
    SQLiteDatabase banco_memoria,banco_tabuada;
    EditText edtResposta,edtResposta2,edtResposta3;
    Cursor dados1;
    TextView tvAcertos,tvSomador,tvSomando,tvVidas,tvAcertos2,tvVidas2,tvOperacao;
    TextView tvMultiplicador,tvMultiplicando,tvDivisor,tvDividindo,tvVidas3,tvAcertos3;
    Button btnConfirmar,btnVoltarMenu,btnConfirmar2,btnConfirmar3,btnRankingTabuada;
    Button btnTabuadaRanking;
    Button btnUm,btnDois,btnTres,btnQuatro,btnCinco,btnSeis,btnSete,btnOito,btnNove,btnZero;
    LinearLayout llPrimeiro, llSegundo, llTerceiro, llQuarto, llQuinto;
    TextView tvPrimeiroLugar, tvSegundoLugar, tvTerceiroLugar, tvQuartoLugar, tvQuintoLugar;
    Button btnVoltarAdicao,btnJogoSombra,btnFase3;
    int divisor,dividindo,produto3;
    int multiplicador, multiplicando,produto2;
    int somador, somando,produto;
    int acertos = 0, vidas = 5;

    //primeira fase
    Button btnPortaA,btnPortaB,btnPortaC,btnPortaD;
    Button btnPorta1,btnPorta2,btnPorta3,btnPorta4;
    int parX = 0,imparX = 0,contador = 0;
    //segunda fase
    Button btnPortaE, btnPortaF, btnPortaG, btnPortaH,btnPortaI;
    Button btnPorta5, btnPorta6, btnPorta7, btnPorta8, btnPorta9;
    int parY = 0,imparY = 0,contador2 = 0;
    //terceira fase
    Button  btnPortaJ, btnPortaK, btnPortaL, btnPortaM, btnPortaN, btnPortaO, btnPortaP, btnPortaQ;
    Button btnPorta10, btnPorta11, btnPorta12, btnPorta13, btnPorta14, btnPorta15, btnPorta16;
    int parZ = 0,imparZ = 0,contador3 = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.janela);
        btnJogar = (Button) findViewById(R.id.btnJogar1);
        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                janelaDeMenus();

            }
        });

    }

    public void janelaDeMenus() {
        setContentView(R.layout.selecaodejogos);
        btnJogoMemoria = (Button)findViewById(R.id.btnJogoMemoria);
        btnJogoMemoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria();
            }
        });

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnMestreTabuada = (Button)findViewById(R.id.btnMestreTabuada);
        btnMestreTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabuada();
            }
        });

        btnJogoSombra = (Button)findViewById(R.id.btnJogoSombra);
        btnJogoSombra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sombra();
            }
        });
    }

    public  void sombra() {
        setContentView(R.layout.jogosombra);
    }

    public void tabuada() {
        setContentView(R.layout.menu_tabuada);

        btnVoltarTabuada = (Button)findViewById(R.id.btnVoltarTabuada);
        btnVoltarTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                janelaDeMenus();
            }
        });

        btnAdicao = (Button)findViewById(R.id.btnAdicao);
        btnSubtracao = (Button)findViewById(R.id.btnSubtracao);
        btnDivisao = (Button)findViewById(R.id.btnDivisao);
        btnMultiplicacao = (Button)findViewById(R.id.btnMultiplicacao);
        btnRankingTabuada = (Button)findViewById(R.id.btnRankingTabuada);

        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicao();
            }
        });
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtracao();
            }
        });
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divisao();
            }
        });
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplicacao();
            }
        });
        btnRankingTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rankingTabuada();
            }
        });

    }

    public void rankingTabuada() {
        setContentView(R.layout.ranking_tabuada);
        try {
            banco_tabuada = openOrCreateDatabase("senai",CONTEXT_IGNORE_SECURITY,null);
            banco_tabuada.execSQL("CREATE TABLE IF NOT EXISTS tabuada(id integer primary key autoincrement,nome text,acertos integer)");
            Toast.makeText(MainActivity.this, "Tabela executada com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Erro ao executar tabela!", Toast.LENGTH_SHORT).show();
        }

        btnTabuadaRanking = (Button)findViewById(R.id.btnTabuadaRanking);
        btnTabuadaRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabuada();
            }
        });

        llPrimeiro = (LinearLayout)findViewById(R.id.llPrimeiro);
        llSegundo = (LinearLayout)findViewById(R.id.llSegundo);
        llTerceiro = (LinearLayout)findViewById(R.id.llTerceiro);
        llQuarto = (LinearLayout)findViewById(R.id.llQuarto);
        llQuinto = (LinearLayout)findViewById(R.id.llQuinto);
        tvPrimeiroLugar = (TextView)findViewById(R.id.tvPrimeiroLugar);
        tvSegundoLugar = (TextView)findViewById(R.id.tvSegundoLugar);
        tvTerceiroLugar = (TextView)findViewById(R.id.tvTerceiroLugar);
        tvQuartoLugar = (TextView)findViewById(R.id.tvQuartoLugar);
        tvQuintoLugar = (TextView)findViewById(R.id.tvQuintoLugar);

        dados1 = banco_tabuada.query("tabuada", new String[]{"nome","acertos"}, null,null,null,null,"acertos");

        if (dados1.moveToLast()) {
            tvPrimeiroLugar.setText(dados1.getString(dados1.getColumnIndex("nome"))+"("+dados1.getString(dados1.getColumnIndex("acertos"))+" )");
        }else {
            llPrimeiro.setVisibility(View.GONE);
        }
        if (dados1.moveToPrevious()) {
            tvSegundoLugar.setText(dados1.getString(dados1.getColumnIndex("nome"))+"("+dados1.getString(dados1.getColumnIndex("acertos"))+" )");
        }else {
            llSegundo.setVisibility(View.GONE);
        }
        if (dados1.moveToPrevious()) {
            tvTerceiroLugar.setText(dados1.getString(dados1.getColumnIndex("nome"))+"("+dados1.getString(dados1.getColumnIndex("acertos"))+" )");
        }else {
            llTerceiro.setVisibility(View.GONE);
        }
        if (dados1.moveToPrevious()) {
            tvQuartoLugar.setText(dados1.getString(dados1.getColumnIndex("nome"))+"("+dados1.getString(dados1.getColumnIndex("acertos"))+" )");
        }else {
            llQuarto.setVisibility(View.GONE);
        }
        if (dados1.moveToPrevious()) {
            tvQuintoLugar.setText(dados1.getString(dados1.getColumnIndex("nome"))+"("+dados1.getString(dados1.getColumnIndex("acertos"))+" )");
        }else{
            llQuinto.setVisibility(View.GONE);
        }


    }

    public void multiplicacao() {
        setContentView(R.layout.tabuada_multiplicacao);

        btnConfirmar2 = (Button)findViewById(R.id.btnConfirmar2);
        edtResposta2 = (EditText)findViewById(R.id.edtResposta2);
        tvAcertos2 = (TextView)findViewById(R.id.tvAcertos2);
        tvVidas2 = (TextView)findViewById(R.id.tvVidas2);
        tvMultiplicador = (TextView)findViewById(R.id.tvMultiplicador);
        tvMultiplicando = (TextView)findViewById(R.id.tvMultiplicando);

        geradorDeJogadas2();
        btnConfirmar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resposta = 0;
                if (edtResposta2.getText().toString().trim().equals("")){
                    resposta = 0;
                }else{
                    resposta = Integer.parseInt(edtResposta2.getText().toString());
                }
                if (resposta == produto2) {
                    ++acertos;
                    Toast.makeText(MainActivity.this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                    geradorDeJogadas2();
                }else{
                    --vidas;
                    Toast.makeText(MainActivity.this, "Resposta Incorreta", Toast.LENGTH_SHORT).show();
                    geradorDeJogadas2();
                    if (vidas==0){
                        Toast.makeText(MainActivity.this, "Fim de jogo", Toast.LENGTH_SHORT).show();
                        gameOver();
                    }
                }
            }
        });

            }

    public void geradorDeJogadas2() {
        Random r = new Random();
        int numero = 0 ;
        do {
            numero = r.nextInt(10);
        }while (numero == 0);

        multiplicador = numero;

        do {
            numero = r.nextInt(10);

        }while (numero ==0);

        multiplicando = numero;

        produto2 = multiplicador * multiplicando;

        tvMultiplicador.setText(String.valueOf(multiplicador));
        tvMultiplicando.setText(String.valueOf(multiplicando));
        tvVidas2.setText(String.valueOf(vidas));
        tvAcertos2.setText(String.valueOf(acertos));


        edtResposta2.setText(null);
        edtResposta2.requestFocus();

    }

    public void divisao() {
        setContentView(R.layout.tabuada_divisao);

        btnConfirmar3 = (Button)findViewById(R.id.btnConfirmar3);
        tvVidas3 = (TextView)findViewById(R.id.tvVidas3);
        tvAcertos3 = (TextView)findViewById(R.id.tvAcertos3);
        tvDivisor = (TextView)findViewById(R.id.tvDivisor);
        tvDividindo = (TextView)findViewById(R.id.tvDividindo);
        edtResposta3 = (EditText)findViewById(R.id.edtResposta3);

        geradorDeJogadas3();
        btnConfirmar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resposta = 0;
                if (edtResposta3.getText().toString().trim().equals("")){
                    resposta = 0;
                }else{
                    resposta = Integer.parseInt(edtResposta3.getText().toString());
                }
                if (resposta == produto3) {
                    ++acertos;
                    Toast.makeText(MainActivity.this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                    geradorDeJogadas3();
                }else{
                    --vidas;
                    Toast.makeText(MainActivity.this, "Resposta Incorreta", Toast.LENGTH_SHORT).show();
                    geradorDeJogadas3();
                    if (vidas==0){
                        Toast.makeText(MainActivity.this, "Fim de jogo", Toast.LENGTH_SHORT).show();
                        gameOver();
                    }
                }
            }
        });
            }

    public void geradorDeJogadas3() {

        geradorDeNumero();
        testaDivisaoExata();

        produto3 = divisor / dividindo;
        tvDivisor.setText(String.valueOf(divisor));
        tvDividindo.setText(String.valueOf(dividindo));
        tvVidas3.setText(String.valueOf(vidas));
        tvAcertos3.setText(String.valueOf(acertos));

        edtResposta3.setText(null);
        edtResposta3.requestFocus();
    }

    public void geradorDeNumero(){
        Random r = new Random();
        int numero = 0 ;
        do {
            numero = r.nextInt(10);
        }while (numero == 0);
        divisor = numero;
        do {
            numero = r.nextInt(10);
        }while (numero ==0);
        dividindo = numero;
    }

    public void testaDivisaoExata(){
        while (true){
            if ( divisor > dividindo) {
                if (divisor % dividindo == 0){
                    break;
                }else{
                    geradorDeNumero();
                }
            }else{
                geradorDeNumero();
            }
        }
    }

    public void subtracao() {
    }

    public void adicao() {
        setContentView(R.layout.tabuada_adicao);

        acertos = 0;
        vidas = 5;
        tvSomador = (TextView)findViewById(R.id.tvSomador);
        tvSomando = (TextView)findViewById(R.id.tvSomando);
        btnConfirmar = (Button)findViewById(R.id.btnConfirmar);
        tvAcertos = (TextView)findViewById(R.id.tvAcertos);
        tvVidas = (TextView)findViewById(R.id.tvVidas);
        btnUm = (Button)findViewById(R.id.btnUm);
        btnDois = (Button)findViewById(R.id.btnDois);
        btnTres = (Button)findViewById(R.id.btnTres);
        btnQuatro = (Button)findViewById(R.id.btnQuatro);
        btnCinco = (Button)findViewById(R.id.btnCinco);
        btnSeis = (Button)findViewById(R.id.btnSeis);
        btnSete = (Button)findViewById(R.id.btnSete);
        btnOito = (Button)findViewById(R.id.btnOito);
        btnNove = (Button)findViewById(R.id.btnNove);
        btnZero = (Button)findViewById(R.id.btnZero);

        tvOperacao = (TextView)findViewById(R.id.tvOperacao);
        tvOperacao.setText("");

        geradorDeJogadas();
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int resposta = 0;
                if (tvOperacao.getText().toString().trim().equals("")){
                    resposta = 0;
                }else{
                   resposta = Integer.parseInt(tvOperacao.getText().toString());
                }
                if (resposta == produto) {
                    ++acertos;
                    Toast.makeText(MainActivity.this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                    geradorDeJogadas();
                }else{
                    --vidas;
                    Toast.makeText(MainActivity.this, "Resposta Incorreta", Toast.LENGTH_SHORT).show();
                    geradorDeJogadas();
                    if (vidas==0){
                        Toast.makeText(MainActivity.this, "Fim de jogo", Toast.LENGTH_SHORT).show();
                        gameOver();
                    }
                }
            }
        });

        //btnVoltarAdicao = (Button)findViewById(R.id.btnVoltarAdicao);
      /*  btnVoltarAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabuada();
            }
        });*/

            }

    public void geradorDeJogadas() {
        Random r = new Random();
        int numero = 0 ;
        do {
            numero = r.nextInt(10);
        }while (numero == 0);

        somador = numero;

        do {
            numero = r.nextInt(10);

        }while (numero ==0);

        somando = numero;

        produto = somador + somando;

        tvSomador.setText(String.valueOf(somador));
        tvSomando.setText(String.valueOf(somando));
        tvVidas.setText(String.valueOf(vidas));
        tvAcertos.setText(String.valueOf(acertos));


        edtResposta.setText(null);
        edtResposta.requestFocus();


    }

    public void gameOver() {
        setContentView(R.layout.game_over);

        btnVoltarMenu = (Button)findViewById(R.id.btnVoltarMenu);
        btnVoltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabuada();
            }
        });
    }

    public void login() {
        setContentView(R.layout.login);

        btnJogarLogin = (Button)findViewById(R.id.btnJogarLogin);
        btnJogarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                janelaDeMenus();
            }
        });
    }

    public void memoria() {
        setContentView(R.layout.menu_memoria);
        btnFase1 = (Button)findViewById(R.id.btnFase1);
        btnFase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiraFase();

            }
        });

        btnFase2 = (Button)findViewById(R.id.btnFase2);
        btnFase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              segundaFase();
            }
        });

        btnFase3 = (Button)findViewById(R.id.btnFase3);
        btnFase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terceiraFase();
            }
        });

        btnVoltar1 = (Button)findViewById(R.id.btnVoltar1);
        btnVoltar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                janelaDeMenus();
            }
        });

        btnRanking = (Button)findViewById(R.id.btnRanking);
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rakingMemoria();
            }
        });

    }

    public void terceiraFase() {
        setContentView(R.layout.jogomemoria_fase3);

        btnPortaJ = (Button)findViewById(R.id.btnPortaJ); btnPortaL = (Button)findViewById(R.id.btnPortaL);
        btnPortaK = (Button)findViewById(R.id.btnPortaK); btnPortaM = (Button)findViewById(R.id.btnPortaM);
        btnPortaN = (Button)findViewById(R.id.btnPortaN); btnPortaO = (Button)findViewById(R.id.btnPortaO);
        btnPortaP = (Button)findViewById(R.id.btnPortaP); btnPorta16 = (Button)findViewById(R.id.btnPorta16);
        btnPorta10 = (Button)findViewById(R.id.btnPorta10); btnPorta11 = (Button)findViewById(R.id.btnPorta11);
        btnPorta12 = (Button)findViewById(R.id.btnPorta12); btnPorta13 = (Button)findViewById(R.id.btnPorta13);
        btnPorta14 = (Button)findViewById(R.id.btnPorta14); btnPorta15 = (Button)findViewById(R.id.btnPorta15);

        btnPortaJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaJ.setBackgroundResource(R.drawable.porta4);
                contador3++;
                if(contador3 % 2 == 0){
                    parZ = 1;
                    testaPares3();
                }else{
                    imparZ = 1;
                }

            }
        });

        btnPortaK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaK.setBackgroundResource(R.drawable.porta7);
                contador3++;
                if(contador3 % 2 == 0){
                    parZ = 2;
                    testaPares3();
                }else{
                    imparZ = 2;
                }

            }
        });

        btnPortaL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaL.setBackgroundResource(R.drawable.porta3);
                contador3++;
                if(contador3 % 2 == 0){
                    parZ = 3;
                    testaPares3();
                }else{
                    imparZ = 3;
                }
            }
        });

        btnPortaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaM.setBackgroundResource(R.drawable.porta2);
            }
        });

    }

    public void testaPares3() {
    }

    public void rakingMemoria() {
        setContentView(R.layout.ranking_memoria);

        try {
            banco_memoria = openOrCreateDatabase("senai",CONTEXT_IGNORE_SECURITY,null);
            banco_memoria.execSQL("CREATE TABLE IF NOT EXISTS memoria(id integer primary key autoincrement,nome text,acertos integer)");
            Toast.makeText(MainActivity.this, "Tabela executada com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Erro ao executar tabela!", Toast.LENGTH_SHORT).show();
        }
        btnVoltarRanking = (Button)findViewById(R.id.btnVoltarRanking);
        btnVoltarRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria();
            }
        });


    }

    public void segundaFase() {
        setContentView(R.layout.jogomemoriafase2);
        btnVoltar2 = (Button)findViewById(R.id.btnVoltar2);
        btnVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria();
            }
        });
        btnPortaE = (Button)findViewById(R.id.btnPortaE);
        btnPortaF = (Button)findViewById(R.id.btnPortaF);
        btnPortaG = (Button)findViewById(R.id.btnPortaG);
        btnPortaH = (Button)findViewById(R.id.btnPortaH);
        btnPortaI = (Button)findViewById(R.id.btnPortaI);
        btnPorta5 = (Button)findViewById(R.id.btnPorta5);
        btnPorta6 = (Button)findViewById(R.id.btnPorta6);
        btnPorta7 = (Button)findViewById(R.id.btnPorta7);
        btnPorta8 = (Button)findViewById(R.id.btnPorta8);
        btnPorta9 = (Button)findViewById(R.id.btnPorta9);

        btnPortaE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaE.setBackgroundResource(R.drawable.porta5);
                contador2++;
                if(contador2 % 2 == 0){
                    parY = 1;
                    testaPares2();
                }else{
                    imparY = 1;
                }

            }
        });

        btnPortaF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaF.setBackgroundResource(R.drawable.porta6);
                contador2++;
                if(contador2 % 2 == 0){
                    parY = 2;
                    testaPares2();
                }else{
                    imparY = 2;
                }
            }
        });

        btnPortaG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaG.setBackgroundResource(R.drawable.porta7);
                contador2++;
                if(contador2 % 2 == 0){
                    parY = 3;
                    testaPares2();
                }else{
                    imparY = 3;
                }

            }
        });

        btnPortaH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaH.setBackgroundResource(R.drawable.porta8);
                contador2++;
                if(contador2 % 2 == 0){
                    parY = 4;
                    testaPares2();
                }else{
                    imparY = 4;
                }
            }
        });

        btnPortaI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaI.setBackgroundResource(R.drawable.porta9);
                contador2++;
                if(contador2 % 2 == 0){
                    parY = 5;
                    testaPares2();
                }else{
                    imparY = 5;
                }
            }
        });

        btnPorta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta5.setBackgroundResource(R.drawable.porta5);
                contador2++;
                if(contador2 % 2 == 0){
                    parY = 1;
                    testaPares2();
                }else{
                    imparY = 1;
                }
            }
        });

        btnPorta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta6.setBackgroundResource(R.drawable.porta6);
                contador2++;
                if (contador2 % 2 ==0){
                    parY = 2;
                    testaPares2();
                }else{
                    imparY = 2;
                }
                }
        });

        btnPorta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta7.setBackgroundResource(R.drawable.porta7);
                contador2++;
                if (contador2 % 2 ==0){
                    parY = 3;
                    testaPares2();
                }else{
                    imparY = 3;
                }

            }
        });

        btnPorta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta8.setBackgroundResource(R.drawable.porta8);
                contador2++;
                if (contador2 % 2 ==0){
                    parY = 4;
                    testaPares2();
                }else{
                    imparY = 4;
                }
            }
        });

        btnPorta9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta9.setBackgroundResource(R.drawable.porta9);
                contador2++;
                if (contador2 % 2 ==0){
                    parY = 5;
                    testaPares2();
                }else{
                    imparY = 5;
                }
            }
        });

    }

    public void testaPares2() {
        if(parY == imparY){
            switch (parY){
                case 1 : btnPorta5.setEnabled(false); btnPortaE.setEnabled(false);break;
                case 2 : btnPorta6.setEnabled(false); btnPortaF.setEnabled(false);break;
                case 3 : btnPorta7.setEnabled(false); btnPortaG.setEnabled(false);break;
                case 4 : btnPorta8.setEnabled(false); btnPortaH.setEnabled(false);break;
                case 5 : btnPorta9.setEnabled(false); btnPortaI.setEnabled(false);break;
            }
        }else{
            switch (imparY){
                case 1 :  btnPortaE.setBackgroundResource(R.drawable.porta); btnPorta5.setBackgroundResource(R.drawable.porta); break;
                case 2 :  btnPortaF.setBackgroundResource(R.drawable.porta); btnPorta6.setBackgroundResource(R.drawable.porta); break;
                case 3 :  btnPortaG.setBackgroundResource(R.drawable.porta); btnPorta7.setBackgroundResource(R.drawable.porta); break;
                case 4 :  btnPortaH.setBackgroundResource(R.drawable.porta); btnPorta8.setBackgroundResource(R.drawable.porta); break;
                case 5 :  btnPortaI.setBackgroundResource(R.drawable.porta); btnPorta9.setBackgroundResource(R.drawable.porta); break;
            }
            switch (parY){
                case 1 :  btnPortaE.setBackgroundResource(R.drawable.porta); btnPorta5.setBackgroundResource(R.drawable.porta); break;
                case 2 :  btnPortaF.setBackgroundResource(R.drawable.porta); btnPorta6.setBackgroundResource(R.drawable.porta); break;
                case 3 :  btnPortaG.setBackgroundResource(R.drawable.porta); btnPorta7.setBackgroundResource(R.drawable.porta); break;
                case 4 :  btnPortaH.setBackgroundResource(R.drawable.porta); btnPorta8.setBackgroundResource(R.drawable.porta); break;
                case 5 :  btnPortaI.setBackgroundResource(R.drawable.porta); btnPorta9.setBackgroundResource(R.drawable.porta); break;
        }
        }

        if(btnPortaE.isEnabled() == false && btnPortaF.isEnabled() == false && btnPortaG.isEnabled() == false && btnPortaH.isEnabled() == false && btnPortaI.isEnabled() == false
                && btnPorta5.isEnabled() == false && btnPorta6.isEnabled() == false && btnPorta7.isEnabled() == false && btnPorta8.isEnabled() == false && btnPorta9.isEnabled() == false){
            Toast.makeText(MainActivity.this, "Parabéns", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Continue Jogando", Toast.LENGTH_SHORT).show();
        }
    }

    public void primeiraFase() {
        setContentView(R.layout.jogo_memoria);
        btnVoltar = (Button)findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                memoria();
            }
        });
        btnPortaA = (Button)findViewById(R.id.btnPortaA);
        btnPortaB = (Button)findViewById(R.id.btnPortaB);
        btnPortaC = (Button)findViewById(R.id.btnPortaC);
        btnPortaD = (Button)findViewById(R.id.btnPortaD);
        btnPorta1 = (Button)findViewById(R.id.btnPorta1);
        btnPorta2 = (Button)findViewById(R.id.btnPorta2);
        btnPorta3 = (Button)findViewById(R.id.btnPorta3);
        btnPorta4 = (Button)findViewById(R.id.btnPorta4);

        btnPortaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaA.setBackgroundResource(R.drawable.porta1);
                contador++;
                if(contador % 2 == 0){
                    parX = 1;
                    Thread timerThread = new Thread() {
                        public void run() {
                            try {
                                sleep(2000);
                                testaPares();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timerThread.start();
                }else{
                    imparX = 1;
                    btnPortaA.setEnabled(false);
                }
            }
        });
        btnPortaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaB.setBackgroundResource(R.drawable.porta2);
                contador++;
                if(contador % 2 == 0){
                    parX = 2;
                    Thread timerThread = new Thread() {
                        public void run() {
                            try {
                                sleep(2000);
                                testaPares();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timerThread.start();
                }else{
                    imparX = 2;
                    btnPortaB.setEnabled(false);
                }
            }
        });
        btnPortaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaC.setBackgroundResource(R.drawable.porta3);
                contador++;
                if(contador % 2 == 0){
                    parX = 3;
                    Thread timerThread = new Thread() {
                        public void run() {
                            try {
                                sleep(2000);
                                testaPares();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timerThread.start();
                }else{
                    imparX = 3;
                    btnPortaC.setEnabled(false);
                }
            }
        });
        btnPortaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPortaD.setBackgroundResource(R.drawable.porta4);
                contador++;
                if(contador % 2 == 0){
                    parX = 4;
                    Thread timerThread = new Thread() {
                        public void run() {
                            try {
                                sleep(2000);
                                testaPares();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timerThread.start();
                }else{
                    imparX = 4;
                    btnPortaD.setEnabled(false);
                }
            }
        });
        btnPorta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta1.setBackgroundResource(R.drawable.porta1);
                contador++;
                if(contador % 2 == 0){
                    parX = 1;
                    Thread timerThread = new Thread() {
                        public void run() {
                            try {
                                sleep(2000);
                                testaPares();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timerThread.start();
                }else{
                    imparX = 1;
                    btnPorta1.setEnabled(false);
                }
            }
        });
        btnPorta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta2.setBackgroundResource(R.drawable.porta2);
                contador++;
                if(contador % 2 == 0){
                    parX = 2;
                    Thread timerThread = new Thread() {
                        public void run() {
                            try {
                                sleep(2000);
                                testaPares();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timerThread.start();
                }else{
                    imparX = 2;
                    btnPorta2.setEnabled(false);
                }
            }
        });
        btnPorta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta3.setBackgroundResource(R.drawable.porta3);
                contador++;
                if(contador % 2 == 0){
                    parX = 3;
                    Thread timerThread = new Thread() {
                        public void run() {
                            try {
                                sleep(2000);
                                testaPares();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timerThread.start();
                }else{
                    imparX = 3;
                    btnPorta3.setEnabled(false);
                }
            }
        });
        btnPorta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPorta4.setBackgroundResource(R.drawable.porta4);
                contador++;
                if(contador % 2 == 0){
                    parX = 4;
                    Thread timerThread = new Thread() {
                        public void run() {
                            try {
                                sleep(2000);
                                testaPares();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    timerThread.start();
                }else{
                    imparX = 4;
                    btnPorta4.setEnabled(false);
                }
            }
        });

    }

    public void testaPares(){

        if (parX == imparX) {
            switch (parX) {
                case 1:
                    btnPorta1.setEnabled(false);
                    btnPortaA.setEnabled(false);
                    break;
                case 2:
                    btnPorta2.setEnabled(false);
                    btnPortaB.setEnabled(false);
                    break;
                case 3:
                    btnPorta3.setEnabled(false);
                    btnPortaC.setEnabled(false);
                    break;
                case 4:
                    btnPorta4.setEnabled(false);
                    btnPortaD.setEnabled(false);
                    break;
            }
        } else {
            switch (imparX) {
                case 1:
                    btnPortaA.setEnabled(true);
                    btnPorta1.setEnabled(true);
                    btnPortaA.setBackgroundResource(R.drawable.porta);
                    btnPorta1.setBackgroundResource(R.drawable.porta);
                    break;
                case 2:
                    btnPortaB.setEnabled(true);
                    btnPorta2.setEnabled(true);
                    btnPortaB.setBackgroundResource(R.drawable.porta);
                    btnPorta2.setBackgroundResource(R.drawable.porta);
                    break;
                case 3:
                    btnPortaC.setEnabled(true);
                    btnPorta3.setEnabled(true);
                    btnPortaC.setBackgroundResource(R.drawable.porta);
                    btnPorta3.setBackgroundResource(R.drawable.porta);
                    break;
                case 4:
                    btnPortaD.setEnabled(true);
                    btnPorta4.setEnabled(true);
                    btnPortaD.setBackgroundResource(R.drawable.porta);
                    btnPorta4.setBackgroundResource(R.drawable.porta);
                    break;
            }
            switch (parX) {
                case 1:
                    btnPortaA.setEnabled(true);
                    btnPorta1.setEnabled(true);
                    btnPortaA.setBackgroundResource(R.drawable.porta);
                    btnPorta1.setBackgroundResource(R.drawable.porta);
                    break;
                case 2:
                    btnPortaB.setEnabled(true);
                    btnPorta2.setEnabled(true);
                    btnPortaB.setBackgroundResource(R.drawable.porta);
                    btnPorta2.setBackgroundResource(R.drawable.porta);
                    break;
                case 3:
                    btnPortaC.setEnabled(true);
                    btnPorta3.setEnabled(true);
                    btnPortaC.setBackgroundResource(R.drawable.porta);
                    btnPorta3.setBackgroundResource(R.drawable.porta);
                    break;
                case 4:
                    btnPortaD.setEnabled(true);
                    btnPorta4.setEnabled(true);
                    btnPortaD.setBackgroundResource(R.drawable.porta);
                    btnPorta4.setBackgroundResource(R.drawable.porta);
                    break;
            }
        }

        if (btnPortaA.isEnabled() == false && btnPortaB.isEnabled() == false && btnPortaC.isEnabled() == false && btnPortaD.isEnabled() == false
                && btnPorta1.isEnabled() == false && btnPorta2.isEnabled() == false && btnPorta3.isEnabled() == false && btnPorta4.isEnabled() == false) {
            Toast.makeText(MainActivity.this, "Parabéns", Toast.LENGTH_SHORT).show();
            segundaFase();
        } else {
            Toast.makeText(MainActivity.this, "Continue Jogando", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed(){

    }


}
