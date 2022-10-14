package tech.devinhouse.model;

public enum EnumProfessor {
    Graduacao_incompleta,
    Graduacao_completa,
    Mestrado,
    Doutorado,
    Front_End,
    Back_End,
    Full_Stack,
    Todos,
    Ativo,
    Inativo;


    public static EnumProfessor obterGraduacaoProfessor(int codigoGradProfessor) {
        if(codigoGradProfessor>0 && codigoGradProfessor<5){
        EnumProfessor[] GradProfessor = EnumProfessor.values();
        return GradProfessor[codigoGradProfessor - 1];
        }
        System.out.println("Codigo invalido");
        return null;
    }

    public static EnumProfessor obterExperienciaPreofessor(int codigoExpProfessor ){
        if(codigoExpProfessor>0 && codigoExpProfessor<5){
            EnumProfessor[] expProfessor =EnumProfessor.values();
            return expProfessor [codigoExpProfessor+3];
        }
        System.out.println("Codigo invalido");
        return null;
    }

    public static EnumProfessor obterStatusPprofessor(int codigoStatProfessor){
        if(codigoStatProfessor>0 && codigoStatProfessor<3){
            EnumProfessor[] statProfessor =EnumProfessor.values();
            return statProfessor[codigoStatProfessor+7];
        }
        System.out.println("Codigo invalido");
        return null;
    }
}