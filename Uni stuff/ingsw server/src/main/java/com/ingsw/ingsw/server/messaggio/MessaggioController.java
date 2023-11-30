package com.ingsw.ingsw.server.messaggio;

import com.ingsw.ingsw.server.utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(path = "api/v1/Messaggio")
public class MessaggioController {
    private final MessaggioService MessaggioService;

    @Autowired
    public MessaggioController(MessaggioService MessaggioService) { this.MessaggioService = MessaggioService;}

    @GetMapping()
    public List<Messaggio> getMessaggio() { return MessaggioService.getMessaggio();}

    @PostMapping
    public void registerNewMessaggio(@RequestBody Messaggio Messaggio) { MessaggioService.addNewMessaggio(Messaggio);}

    @DeleteMapping(path = "{MessaggioId}")
    public void deleteMessaggio(@PathVariable("MessaggioId") Long MessaggioId) { MessaggioService.deleteMessaggio(MessaggioId);}

    @GetMapping(path =  "/unread")
    public ResponseEntity<Object> getUnreadMessages(@RequestParam String userId,@RequestParam String username){
        int i=0;
        System.out.println("Entro nel metodo che esegue la query per leggere mess non letti");
        //List<Messaggio>messaggi= MessaggioService.getUnreadMessages(Long.valueOf(userId),username);
        List<Messaggio>messaggi= MessaggioService.getMessaggio();
        List<Messaggio> messagesToBeRemoved = new ArrayList<Messaggio>();
        for(Messaggio m:messaggi){
            for(Utente u:m.getLettori()){
                System.out.println("esamino:"+u.toString()+", è di id "+userId+" ? e di nome"+username+"? (nome trovato:)"+u.getNome() );
                if(Objects.equals(u.getId(), Long.valueOf(userId))){
                    System.out.println("trovato messaggio già letto da "+username);
                    messagesToBeRemoved.add(m);
                }
            }
            if(m.getMittente().equals(username)){
                System.out.println("trovato messaggio già mandato da "+username);
                messagesToBeRemoved.add(m);
            }
        }

        for(Messaggio mess:messagesToBeRemoved){
            messaggi.remove(mess);
        }

        Map<String, Object> responseBody = new HashMap<String, Object>();
        for(Messaggio mess:messaggi){

            responseBody.put("id"+i,mess.getId());
            responseBody.put("corpo"+i,mess.getCorpo());
            responseBody.put("mittente"+i,mess.getMittente());
            i++;
        }

        if(messaggi.isEmpty())
        {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<Object>(responseBody,HttpStatus.OK);
    }
    @PutMapping(path="/readupdate")
    void setMessageAsRead(@RequestBody Map<String, Integer> reqBody){
        MessaggioService.setMessageAsRead(Long.valueOf(reqBody.get("messageId")),Long.valueOf(reqBody.get("userId")));

    }
}
