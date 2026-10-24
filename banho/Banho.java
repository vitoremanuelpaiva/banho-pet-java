package banho;

public class Banho {

    private String motivoFalha = "";
    private static final int CAPACIDADE_MAXIMA_AGUA = 30;
    private static final int CAPACIDADE_MAXIMA_SHAMPOO = 10;
    private static final int AGUA_GASTA_POR_BANHO = 10;
    private static final int SHAMPOO_GASTADO_POR_BANHO = 2;
    private static final int AGUA_GASTA_LAVAGEM_MAQUINA = 3;
    private static final int SHAMPOO_GASTADO_LAVAGEM_MAQUINA = 1;
    private static final int ABASTECIMENTO_EM_LITROS = 2;
    private int capacidadeAgua;
    private boolean pet;
    private int capacidadeShampoo;
    private boolean petLimpo;
    private boolean maquinaLimpa;

    public Banho() {
        capacidadeAgua = CAPACIDADE_MAXIMA_AGUA;
        capacidadeShampoo = CAPACIDADE_MAXIMA_SHAMPOO;
        pet = false;
        petLimpo = false;
        maquinaLimpa = true;
    }

    private boolean falhar(String motivo) {
        this.motivoFalha = motivo;
        return false;
    }

    public boolean darBanho() {
        if (pet != true) {
            return falhar("Você precisa de um pet na máquina para iniciar o banho");
        }
        if (petLimpo == true){
            return falhar("Você não pode dar banho no mesmo pet 2 vezes");
        }
        if (capacidadeAgua < AGUA_GASTA_POR_BANHO) {
            return falhar("A máquina não tem água suficiente para dar o banho no pet, abasteça a água para conseguir");
        }
        if (capacidadeShampoo < SHAMPOO_GASTADO_POR_BANHO) {
            return falhar("A máquina não tem shampoo suficiente para dar o banho no pet, abasteça o shampoo para conseguir");
        }
        this.capacidadeAgua = this.capacidadeAgua - AGUA_GASTA_POR_BANHO;
        this.capacidadeShampoo =  this.capacidadeShampoo - SHAMPOO_GASTADO_POR_BANHO;
        petLimpo = true;
        return true;
    }

    public boolean abastecerAgua(){
        int restante = CAPACIDADE_MAXIMA_AGUA - this.capacidadeAgua;
        if (restante == 0){
            return falhar("A sua máquina já está cheia de água");
        }
        if (restante < ABASTECIMENTO_EM_LITROS){
            return falhar("Você não consegue colocar um abastecimento inteiro na sua máquina, pois o abastecimento é de "+ ABASTECIMENTO_EM_LITROS +"L e só faltam "+ restante +"L para completar os "+ CAPACIDADE_MAXIMA_AGUA +"L");
        }
        this.capacidadeAgua = this.capacidadeAgua + ABASTECIMENTO_EM_LITROS;
        return true;
    }

    public boolean abastecerShampoo(){
        int restante = CAPACIDADE_MAXIMA_SHAMPOO - this.capacidadeShampoo;
        if (restante == 0){
            return falhar("A sua máquina já está cheia de shampoo");
        }
        if (restante < ABASTECIMENTO_EM_LITROS){
            return falhar("Você não consegue colocar um abastecimento inteiro na sua máquina, pois o abastecimento é de "+ ABASTECIMENTO_EM_LITROS +"L e só faltam "+ restante +"L para completar os "+ CAPACIDADE_MAXIMA_SHAMPOO +"L");
        }
        this.capacidadeShampoo = this.capacidadeShampoo + ABASTECIMENTO_EM_LITROS;
        return true;
    }

    public boolean temPetBanho(){
        if (pet != true){
            return falhar("Não tem nenhum pet no banho");
        }
        return true;
    }

    public boolean colocarPet(){
        if (pet == true){
            return falhar("Já tem um pet na máquina");
        }
        if (maquinaLimpa != true){
            return falhar("A máquina precisa estar limpa para colocar outro pet");
        }
        this.pet = true;
        petLimpo = false;
        return true;
    }

    public boolean retirarPet(){
        if(pet != true){
            return falhar("Não há nenhum pet na máquina");
        }
        if(petLimpo != true){
            this.pet = false;
            maquinaLimpa = false;
            return true;
        }
        this.pet = false;
        return true;
    }

    public boolean limparMaquina(){
        if (maquinaLimpa == true){
            return falhar("A máquina já está limpa");
        }
        if (pet == true){
            return falhar("Retire o pet de dentro da máquina para lavar a máquina");
        }
        if (capacidadeAgua < AGUA_GASTA_LAVAGEM_MAQUINA){
            return falhar("Sua máquina não possui água suficiente para limpá-la");
        }
        if (capacidadeShampoo < SHAMPOO_GASTADO_LAVAGEM_MAQUINA){
            return falhar("Sua máquina não possui shampoo suficiente para limpá-la");
        }
        this.capacidadeAgua = this.capacidadeAgua - AGUA_GASTA_LAVAGEM_MAQUINA;
        this.capacidadeShampoo = this.capacidadeShampoo - SHAMPOO_GASTADO_LAVAGEM_MAQUINA;
        maquinaLimpa = true;
        return true;
    }

    public int getCapacidadeAgua() {
        return this.capacidadeAgua;
    }

    public int getCapacidadeShampoo() {
        return this.capacidadeShampoo;
    }

    public String getMotivoFalha() {
        return this.motivoFalha;
    }

}