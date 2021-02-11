package ru.job4j.ood.ocp;

public class WriteTools {
    private static class Pencil {
        private boolean canDelete;
        private Pencil() {
            this.canDelete = true;
        }

        private void write() {
            if (canDelete) {
                System.out.println("Don't worry. This i can delete.");
            }
        }
    }

    private static class Pen extends Pencil {
        private boolean canDelete;
        private Pen() {
            this.canDelete = false;
        }
        private void write() {
            if (!canDelete) {
                System.out.println("warning! Attention! Can not delete");
            }
        }
    }
}
