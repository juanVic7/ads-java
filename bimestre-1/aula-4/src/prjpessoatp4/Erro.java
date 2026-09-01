package prjpessoatp4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MauricioAsenjo
 */
public class Erro {
private static boolean erro;
private static String mens;

public static void setErro(boolean _erro)
{
erro=_erro;
}
public static void setErro(String _mens)
{
erro=true;
mens=_mens;
}
public static boolean getErro() {return erro;}
public static String getMens() {return mens;}    
}
