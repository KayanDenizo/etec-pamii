# WhatsApp List: RecyclerView

Projeto da disciplina **Programação de Aplicativos Mobile II** — Etec Uirapuru
Professor: Fabio Claret

App Android nativo em **Java** que mostra uma lista de contatos no estilo do
WhatsApp: cada linha tem a **foto redonda**, o **nome** e a **última mensagem**
do usuário. A lista é montada com `RecyclerView`.

---

## Conceitos

| Peça | Papel |
|---|---|
| `RecyclerView` | Componente que exibe a lista. Os itens que saem da tela são **reciclados** para economizar memória e ganhar desempenho. |
| `LayoutManager` | Monta o `RecyclerView` e define o formato da lista: vertical, horizontal ou em grade. Aqui é um `LinearLayoutManager` vertical. |
| `Adapter` | O "cérebro" da lista. Adapta os dados (a lista de `UsuarioModel`) para as visualizações. |
| `ViewHolder` | Guarda os componentes de um item (foto, nome, mensagem) criados a partir do `usuario_item.xml`. |

Os três métodos do adapter:

- **`onCreateViewHolder`**: infla o layout `usuario_item` e cria o `ViewHolder`.
- **`onBindViewHolder`**: preenche o item da posição atual com a foto, o nome e a mensagem.
- **`getItemCount`**: devolve o tamanho total da lista.

---

## Estrutura

```
app/src/main/
├── AndroidManifest.xml
├── java/com/example/whatsapplist/
│   ├── MainActivity.java          # RecyclerView + LayoutManager + criação dos usuários
│   ├── adapter/
│   │   └── AdapterUsuario.java    # Adapter + UsuarioViewHolder
│   └── model/
│       └── UsuarioModel.java      # foto (int), nome e mensagem
└── res/
    ├── drawable/
    │   ├── usuario1.jpg
    │   └── usuario2.jpg
    ├── layout/
    │   ├── activity_main.xml      # só o RecyclerView
    │   └── usuario_item.xml       # o item que se repete na lista
    └── values/
        └── colors.xml             # cor cinza da linha divisória
```

---

## Passo a passo (resumo do slide)

1. Copiar as fotos para `res/drawable`.
2. Criar o `RecyclerView` no `activity_main.xml` com `match_parent`.
3. Na `MainActivity`, recuperar o `RecyclerView`, definir o `LinearLayoutManager`
   vertical e chamar `setHasFixedSize(true)`.
4. Criar o pacote `model` com a classe `UsuarioModel` (construtor, getters e setters).
   A foto é um `int` porque as imagens do `drawable` são localizadas pelo id da classe `R`.
5. Adicionar a biblioteca **CircleImageView** para a foto redonda.
6. Desenhar o item da lista em `usuario_item.xml`: foto, nome, mensagem e uma linha.
7. Criar o pacote `adapter` com a classe `AdapterUsuario`, que estende
   `RecyclerView.Adapter<AdapterUsuario.UsuarioViewHolder>`.
8. Na `MainActivity`, criar os usuários, passar a lista para o adapter e chamar
   `recyclerView.setAdapter(adapterUsuario)`.

O núcleo do adapter:

```java
@Override
public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View itemLista = layoutInflater.inflate(R.layout.usuario_item, parent, false);
    return new UsuarioViewHolder(itemLista);
}

@Override
public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
    UsuarioModel usuario = usuarioList.get(position);
    holder.foto.setImageResource(usuario.getFoto());
    holder.nome.setText(usuario.getNome());
    holder.mensagem.setText(usuario.getMensagem());
}

@Override
public int getItemCount() {
    return usuarioList.size();
}
```

### Diferenças em relação aos prints do slide

- Os usuários são **adicionados na lista** (`usuarioList.add(...)`) e o método
  `usuarios()` é chamado **antes** de criar o adapter. Nos prints eles só eram
  instanciados, e a lista chegava vazia ao adapter.
- `getItemCount()` retorna `usuarioList.size()` (no print intermediário estava `return 0`).
- O contexto do `LayoutInflater` vem de `parent.getContext()` (a primeira opção do
  slide), então o adapter não precisa receber um `Context` no construtor.
- A foto tem 60dp × 60dp para ficar um círculo certinho.
- O nome usa `?android:attr/textColorPrimary` em vez de preto fixo, para continuar
  legível no tema escuro.

---

## Como rodar

1. Abra a pasta `05-recyclerview-lista-contatos` no **Android Studio** (`File > Open`).
2. Espere o Gradle sincronizar.
3. Rode com ▶ em um emulador ou celular com **Android 7.0 (API 24)** ou superior.

---

## Tecnologias

| Item | Versão |
|---|---|
| Linguagem | Java |
| Pacote | `com.example.whatsapplist` |
| Min SDK | 24 (Android 7.0) |
| Lista | RecyclerView 1.4.0 |
| Foto redonda | [CircleImageView](https://github.com/hdodenhof/CircleImageView) 3.1.0 |
| Layout | ConstraintLayout |

---

## Créditos

Projeto base: [Brunor00m/RecycleView](https://github.com/Brunor00m/RecycleView),
completado a partir do slide *Recycler view: trabalhando com listas*.

---

**Kayan Denizo** · [GitHub](https://github.com/KayanDenizo)
