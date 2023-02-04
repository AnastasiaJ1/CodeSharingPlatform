class ProductDTO {
    private long id;
    private String model;
    private int price;

    public ProductDTO(long id, String model, int price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
