public class KonkurrenceSvømmer extends Medlem
{
    //Constructor super klassen
    public KonkurrenceSvømmer(String navn, String telefonNummer, String adresse, String email, String alder, KontingentType kontingentType, boolean harBetalt) {
        super(navn, telefonNummer, adresse, email, alder, kontingentType, harBetalt);
    }
}
