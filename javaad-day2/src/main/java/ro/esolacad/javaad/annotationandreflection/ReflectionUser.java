package ro.esolacad.javaad.annotationandreflection;

public class ReflectionUser {

    private Long id;

    @ShouldRead(false)
    private String secret;

    public String publicVariable;

    public static String publicStaticVariable = "STATIC";

    public ReflectionUser(final Long id, final String secret, final String publicVariable) {
        this.id = id;
        this.secret = secret;
        this.publicVariable = publicVariable;
    }
    public ReflectionUser(final Long id, final String secret) {
        this.id = id;
        this.secret = secret;
    }

    public ReflectionUser() {}

    public void annotateThis() {

    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    private void privateSecretMethod() {
        System.out.println("Secret methd");
    }

    @Override
    public String toString() {
        return "ReflectionUser{" +
                "id=" + id +
                ", secret='" + secret + '\'' +
                ", publicVariable='" + publicVariable + '\'' +
                '}';
    }
}
