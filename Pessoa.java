public class Pessoa {
    private static int kp = 0;  // Contador estático
    private String nome;
    private char sexo;
    private int idade;

    // Construtor padrão
    public Pessoa() {
        kp++;  // Incrementa o contador sempre que uma instância for criada
    }

    // Construtor parametrizado
    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++;  // Incrementa o contador sempre que uma instância for criada
    }

    // Métodos setters e getters
    public static int getKp() {
        return kp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSexo(char sexo) {
        // Valida se o sexo é 'M' ou 'F'
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'");
        }
    }

    public char getSexo() {
        return sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
}
