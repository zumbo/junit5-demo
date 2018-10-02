package ch.zumbo.pm;

class Storage {
    private String data;
    private static int memory = 0;

    String getData() {
        return data;
    }

    void setData(String data) {
        this.data = data;
        memory += data.length();
        if (memory > 20) {
            throw new RuntimeException("Out of memory");
        }
    }


}
