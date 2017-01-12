package com.company;

        import com.company.controller.Controller;
        import com.company.model.Model;
        import com.company.view.View;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model model = new Model();
                View view = new View();
                Controller controller = new Controller(model, view);
                controller.controll();
            }
        });

    }

}
