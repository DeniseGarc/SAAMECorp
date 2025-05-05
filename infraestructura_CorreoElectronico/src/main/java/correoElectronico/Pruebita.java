/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package correoElectronico;

/**
 *
 * @author Maryr
 */
public class Pruebita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICorreoElectronico correoElectronico = new FCorreoElectronico();
        boolean questionMark = correoElectronico.mandarCorreo("mary.ruizp20@gmail.com", "<h1>FULL SPEED AHEAD</h1> why should i give him my support <b>he sacrificed his own cohort</b>");
        System.out.println(questionMark);
    }

}
