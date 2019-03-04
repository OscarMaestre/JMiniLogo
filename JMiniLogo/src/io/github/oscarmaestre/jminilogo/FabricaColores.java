package io.github.oscarmaestre.jminilogo;

import java.awt.Color;

public class FabricaColores {
    public static final int ZX_SPECTRUM_BLACK      =   0;
    public static final int ZX_SPECTRUM_BLUE       =   1;
    public static final int ZX_SPECTRUM_RED        =   2;
    public static final int ZX_SPECTRUM_MAGENTA    =   3;
    public static final int ZX_SPECTRUM_GREEN      =   4;
    public static final int ZX_SPECTRUM_CYAN       =   5;
    public static final int ZX_SPECTRUM_YELLOW     =   6;
    public static final int ZX_SPECTRUM_WHITE      =   7;
    private static int[][] spectrumColors={     {0   , 0   ,  0  }, //Negro
                                                {0   , 0   ,  255}, //Azul
                                                {255 , 0   ,  0  }, //Rojo
                                                {255 , 0   ,  255},//Magenta
                                                {0   , 255 ,  0  }, //Verde
                                                {0   , 255 ,  255}, //Cyan
                                                {255 , 255 , 0   }, //Amarillo
                                                {255 , 255 , 255}   //Blanco
    };
    public static Color getColor(int r, int g, int b){
        Color color;
        if (r<0){
            System.out.println("Componente de rojo menor que 0. Autoajustada a 0");
            r=0;
        }
        if (g<0){
            System.out.println("Componente de verde menor que 0. Autoajustada a 0");
            g=0;
        }
        if (b<0){
            System.out.println("Componente de azul menor que 0. Autoajustada a 0");
            b=0;
        }
        if (r>255){
            System.out.println("Componente de rojo mayor de 255. Autoajustada a 255");
            r=0;
        }
        if (g>255){
            System.out.println("Componente de verde mayor de 255. Autoajustada a 255");
            g=255;
        }
        if (b>255){
            System.out.println("Componente de azul mayor de 255. Autoajustada a 255");
            b=255;
        }
        
        
        color = new Color(r, g, b);
        return color;
    }
    public static Color getColorSpectrum(int color){
        int[] colores;
        colores = spectrumColors[color];
        return getColor(colores[0], colores[1], colores[2]);
        
    }
}
