package ru.job4j.lsp;

class Alcohol {
    private String title;
    private float price;
    private int quantity;

    public Alcohol(String title, float price) {
        this.title = title;
        this.price = price;
    }

    public String sell(int age, float money) {
        if (!this.checkQuantity()) {
            throw new IllegalArgumentException("Not in stock");
        }
        if (money < this.price) {
            throw new IllegalArgumentException("Need more money");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Invalid age. Only for person over 18");
        }
        return this.title;
    }

    public boolean checkQuantity() {
        return this.quantity > 0;
    }
}

class AlcoCocktail extends Alcohol {
    private String title;
    private float price;

    public AlcoCocktail(String title, float price) {
        super(title, price);
    }

    public String sell(int age, float money) {
        if (money < this.price) {
            throw new IllegalArgumentException("Need more money");
        }
            //TODO
        if (age < 21) {
            throw new IllegalArgumentException("Invalid age. Only for person over 21");
        }
        return this.title;
    }
}

class Vodka extends Alcohol {
    private String title;
    private float price;

    public Vodka(String title, float price) {
        super(title, price);
    }

    public String sell(int age, float money) {
        if (money < this.price) {
            throw new IllegalArgumentException("Need more money");
        }
        return this.title;
    }
}
