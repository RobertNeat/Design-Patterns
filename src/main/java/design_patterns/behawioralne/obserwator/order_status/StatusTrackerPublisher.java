package design_patterns.behawioralne.obserwator.order_status;

public class StatusTrackerPublisher extends AbstractPublisher{

    public void zmienStatusDania(String nowyStatus, int procentWykonania){
        System.out.println("Danie zmieniło status na: "+nowyStatus+", calkowity stopien wykonania: "+procentWykonania);
        notifySubscribers(nowyStatus,procentWykonania);// <-- wiadomość nowego stanu jest przekazywana subskrybentom
    }
}
