package edu.utvt.alumnos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entidad que representa a un alumno dentro del sistema.
 *
 * <p>Mapea la tabla {@code alumnos} e incluye información personal,
 * académica y de control de registro.</p>
 */
@Data
@Entity
@Table(name = "alumnos", indexes = {
        @Index(name = "idx_matricula", columnList = "matricula"),
        @Index(name = "idx_correo_electronico", columnList = "correo_electronico"),
        @Index(name = "idx_activo", columnList = "activo")
})
public class Alumno {

    /** Identificador único del alumno. */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    /** Matrícula institucional única del alumno. */
    @Column(length = 20, nullable = false, unique = true)
    private String matricula;

    /** Nombre o nombres del alumno. */
    @Column(length = 100, nullable = false)
    private String nombre;

    /** Primer apellido del alumno. */
    @Column(name = "apellido_paterno", length = 100, nullable = false)
    private String apellidoPaterno;

    /** Segundo apellido del alumno, si aplica. */
    @Column(name = "apellido_materno", length = 100)
    private String apellidoMaterno;

    /** Correo electrónico único de contacto del alumno. */
    @Column(name = "correo_electronico", length = 255, nullable = false, unique = true)
    private String correoElectronico;

    /** Número telefónico de contacto del alumno. */
    @Column(length = 10)
    private String telefono;

    /** Fecha de nacimiento del alumno. */
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    /** Carrera o programa académico al que pertenece el alumno. */
    @Column(length = 100, nullable = false)
    private String carrera;

    /** Semestre actual cursado por el alumno. */
    @Column(nullable = false)
    private Integer semestre;

    /** Indica si el alumno se encuentra activo en el sistema. */
    @Column(nullable = false)
    private boolean activo = true;

    /** Fecha y hora en que se registró el alumno. */
    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;
}
