package aspectjintegration;


public aspect MessageWrapper {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    pointcut doWriting():
            execution(* aspectjintegration.MessageWriter.writeMessage());
    before(): doWriting(){
        System.out.println(prefix);
    }
    after(): doWriting(){
        System.out.println(suffix);
    }
}
