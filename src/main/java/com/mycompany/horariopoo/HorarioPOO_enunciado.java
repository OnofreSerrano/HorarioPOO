/*
 * Proyecto I de ProgramaciÃ³n Orientada a Objetos.
 * RecuperaciÃ³n.
 *
 * Proyecto: HorarioPOO
 * Fecha: Nobriembre 2022
 *
 */

package com.mycompany.horariopoo;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author inigo.sanchez
 */
public class HorarioPOO_enunciado {

    public static final int DURACION_CLASES = 2;
    
    enum Semestre {
        OTOÑO,
        PRIMAVERA
    }

    public static void main(String[] args) {
        // Creando un horario de asignaturas por defecto y mostrando el resultado
        HorarioAsignaturas horarioAsignaturasPrueba = new HorarioAsignaturas();
        horarioAsignaturasPrueba.mostrarInformacionBasica();

        // Creando un horario de asignaturas de Ciencia de Datos
        String grado = "Grado en Ingenieria de Ciencia de Datos";
        HorarioAsignaturas horarioAsignaturas = new HorarioAsignaturas(grado, CursoEnum.CUARTO, Semestre.OTOÑO);
        horarioAsignaturas.mostrarInformacionBasica();

        horarioAsignaturas.inscripcionAsignatura(505201, "EstadÃ­stica II", DiaSemanaEnum.LUNES, 10);
        horarioAsignaturas.inscripcionAsignaturaPractica(505201, "EstadÃ­stica II", DiaSemanaEnum.LUNES, 12, 100, "Grupo Laboratorio 1");
        horarioAsignaturas.inscripcionAsignaturaPractica(505201, "EstadÃ­stica II", DiaSemanaEnum.MIERCOLES, 8, 100, "Grupo Laboratorio 1");
        horarioAsignaturas.inscripcionExamen(505201,LocalDate.parse("2022-12-16"),25);
        horarioAsignaturas.inscripcionAsignatura(505202, "Fundamentos de GenÃ©tica", DiaSemanaEnum.MARTES, 10);
        horarioAsignaturas.inscripcionAsignatura(505202, "Fundamentos de GenÃ©tica", DiaSemanaEnum.MARTES, 12);
        horarioAsignaturas.inscripcionAsignatura(505203, "Algoritmia", DiaSemanaEnum.MIERCOLES, 12);
        horarioAsignaturas.inscripcionAsignatura(505203, "Algoritmia", DiaSemanaEnum.MIERCOLES, 15);
        horarioAsignaturas.inscripcionAsignaturaPractica(505203, "Algoritmia", DiaSemanaEnum.VIERNES, 8, 120, "Grupo Laboratorio 2");
        horarioAsignaturas.inscripcionAsignatura(505204, "ProgramaciÃ³n Orientada a Objetos", DiaSemanaEnum.LUNES, 8);
        horarioAsignaturas.inscripcionExamen(505204,LocalDate.parse("2022-12-18"),50);
        horarioAsignaturas.inscripcionAsignatura(505205, "Ecuaciones Diferenciales Ordinarias", DiaSemanaEnum.JUEVES, 19);
        // Esta inscripciÃ³n de examen, al no recibir fecha, debe de seleccionar la fecha dentro de 2 meses a partir de hoy.
        System.out.println("-- Forzando una inscripcciÃ³n de examen dentro de dos meses a partir de la fecha de hoy.");
        horarioAsignaturas.inscripcionExamen(505205,100);
        // Horas validas, 8,10,12,15,17,19. Esta asignatura no se puede inscribir.
        horarioAsignaturas.inscripcionAsignatura(24035, "Asignatura con Horario NO valido", DiaSemanaEnum.JUEVES, 18);
            
        try {
            horarioAsignaturas.comprobarIncompatibilidades();
            System.out.println();
            System.out.println("-- Forzando un horario incompatible.");
            horarioAsignaturas.inscripcionAsignatura(24035, "Asignatura con Horario NO compatible", DiaSemanaEnum.LUNES, 8);
            horarioAsignaturas.comprobarIncompatibilidades();
        } catch (Exception ex) {
            System.err.println("-- El horario es incompatible."+ex);
        }
        
        //DespuÃ©s de las inscripciones muestro la informaciÃ³n bÃ¡sica de nuevo.
        horarioAsignaturas.mostrarInformacionBasica();

        // Mostrar Horario: Sin parametros, se muestra el horario al completo (Teorico y Practico) + Examenes.
        horarioAsignaturas.mostrarHorario();
        boolean soloPractico = true;
        horarioAsignaturas.mostrarHorario(soloPractico);
          
        // CÃ¡lculo de las horas lectivas segÃºn nÃºmero de asignaturas inscritas.
        System.out.println("Las horas lectivas de su curso son " 
                + String.valueOf(horarioAsignaturas.calculaHoras(DURACION_CLASES)));
        
        // Se muestra el menu con opciones
        mostrarMenu(horarioAsignaturas);
    }
    
    private static void mostrarMenu(HorarioAsignaturas horarioAsig) {

   }

}