package gui2;

import java.util.logging.Level;
import java.util.logging.Logger;

class ThreadForSend implements Runnable {
    Listeners l;

    public ThreadForSend(Listeners l) {
        this.l = l;
    }

    @Override
    public void run() {
        try {
            l.finished(Course.refresh());
        } catch (Exception ex) {
            Logger.getLogger(ThreadForSend.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
