package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Calculo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configura el tipo de respuesta como HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Inicia la página HTML con Bootstrap para estilos
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Tabla de Seno y Coseno</title>");
        out.println("<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head>");
        out.println("<body>");

        // Contenedor principal
        out.println("<div class='container mt-5'>");
        out.println("<h2 class='text-center'>Tabla de Valores de Seno y Coseno</h2>");

        // Inicia la tabla con estilos de Bootstrap
        out.println("<table class='table table-bordered table-striped mt-4'>");
        out.println("<thead class='thead-dark'><tr><th>Ángulo</th><th>Seno</th><th>Coseno</th></tr></thead>");
        out.println("<tbody>");

        // Calcula y muestra los valores de seno y coseno para cada ángulo (de 0 a 360 en intervalos de 15)
        for (int angle = 0; angle <= 360; angle += 15) {
            double radianes = Math.toRadians(angle);  // Convierte el ángulo a radianes
            double seno = Math.sin(radianes);         // Calcula el seno
            double coseno = Math.cos(radianes);       // Calcula el coseno

            // Agrega una fila a la tabla con los valores
            out.println("<tr>");
            out.println("<td>" + angle + "</td>");
            out.println("<td>" + String.format("%.4f", seno) + "</td>");
            out.println("<td>" + String.format("%.4f", coseno) + "</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table>");

        // Botón para regresar a la página de inicio
        out.println("<div class='text-center mt-4'>");
        out.println("<a href='index.html' class='btn btn-secondary'>Regresar</a>");
        out.println("</div>");

        out.println("</div>"); // Cierra el contenedor principal

        // Enlaces a JavaScript de Bootstrap (para funcionalidades interactivas)
        out.println("<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js'></script>");
        out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("</body></html>");
    }
}
