package gui2;
class Send {
    public void sending(Listeners l)
    {
     Thread st = new Thread(new ThreadForSend(l));
     st.start();        
    }
    
}
