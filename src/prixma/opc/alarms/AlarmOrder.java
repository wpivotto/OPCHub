package prixma.opc.alarms;

import java.util.Collections;
import java.util.Comparator;


public enum AlarmOrder implements Comparator<Alarm> {
	
	ByPriority() {
        public int compare(Alarm one, Alarm other) {
           return one.getPriority().level().compareTo(other.getPriority().level());
        }
     },

     BySeverity() {
         public int compare(Alarm one, Alarm other) {
            return one.getSeverity().level().compareTo(other.getSeverity().level());
         }
      },
      
      ByStatus() {
          public int compare(Alarm one, Alarm other) {
             return one.getStatus().level().compareTo(other.getStatus().level());
          }
       },
       
       ByTimestamp() {
           public int compare(Alarm one, Alarm other) {
              return one.getTimestamp().compareTo(other.getTimestamp());
           }
        };

     public Comparator<Alarm> asc() {
        return this;
     }

     public Comparator<Alarm> desc() {
        return Collections.reverseOrder(this);
     }

}
