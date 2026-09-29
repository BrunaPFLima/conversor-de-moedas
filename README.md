<p align="center">
  <img width="100%" src="https://capsule-render.vercel.app/api?type=waving&color=0:3C1361,50:6A0DAD,100:C77DFF&height=180&section=header&text=Conversor%20de%20Moedas&fontSize=46&fontColor=ffffff&fontAlignY=36&desc=Cota%C3%A7%C3%B5es%20em%20tempo%20real%20com%20Java%20e%20ExchangeRate-API&descSize=17&descAlignY=58&animation=fadeIn" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-6A0DAD?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/HttpClient-9D4EDD?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Gson-9D4EDD?style=for-the-badge&logo=google&logoColor=white" />
  <img src="https://img.shields.io/badge/ExchangeRate--API-C77DFF?style=for-the-badge&logo=cashapp&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-C77DFF?style=for-the-badge&logo=apachemaven&logoColor=white" />
</p>

---

## 💜 Sobre

Conversor de moedas de terminal que busca as **cotações atualizadas do dólar** na [ExchangeRate-API](https://www.exchangerate-api.com/) e converte o valor digitado para real, euro ou peso argentino.

Projeto do **challenge da formação Back-end do programa Oracle Next Education (ONE)**, da Alura com a Oracle.

## ✨ Funcionalidades

```
*** Conversor de Moedas ***
1. Converter USD para BRL   🇧🇷
2. Converter USD para EUR   🇪🇺
3. Converter USD para ARS   🇦🇷
0. Sair
```

- 🌐 Cotações em **tempo real**, buscadas uma vez ao iniciar
- 🔁 Menu em loop, pra fazer várias conversões seguidas
- ⚠️ Tratamento de opção inválida e de falha ao obter as taxas

## 🧠 O que pratiquei aqui

- Requisições HTTP com o **`HttpClient`** nativo do Java 11+
- Leitura de JSON e mapeamento pra classe Java com **Gson**
- Uso de `Map<String, Double>` pra acessar as taxas por código da moeda
- Interação com o usuário via `Scanner`
- Chave de API guardada em **variável de ambiente**, fora do código

## 🚀 Como rodar

**Pré-requisitos:** Java 17, Maven e uma chave gratuita da [ExchangeRate-API](https://www.exchangerate-api.com/).

```bash
# 1. Clone o repositório
git clone https://github.com/BrunaPFLima/conversor-de-moedas.git
cd conversor-de-moedas/exchangerate-api/exchangerate-api

# 2. Defina sua chave da API
export EXCHANGE_API_KEY=sua_chave_aqui        # Linux / macOS
# set EXCHANGE_API_KEY=sua_chave_aqui         # Windows (cmd)

# 3. Rode
mvn compile exec:java -Dexec.mainClass=cotacao.Main
```

> No IntelliJ, rode a classe `cotacao.Main` e configure a variável `EXCHANGE_API_KEY` em *Run → Edit Configurations → Environment variables*.

## 🗂️ Estrutura

```
exchangerate-api/exchangerate-api/src/main/java/cotacao
├── Main.java                  # Busca as cotações e mostra o menu
└── ExchangeRateResponse.java  # Mapeia o JSON da API (result, base_code, conversion_rates)
```

---

<p align="center">
  Feito com 💜 por <a href="https://github.com/BrunaPFLima">Bruna Lima</a> ·
  <a href="https://www.linkedin.com/in/bruna-lima-205360144/">LinkedIn</a>
</p>

<p align="center">
  <img width="100%" src="https://capsule-render.vercel.app/api?type=waving&color=0:C77DFF,50:6A0DAD,100:3C1361&height=90&section=footer" />
</p>
