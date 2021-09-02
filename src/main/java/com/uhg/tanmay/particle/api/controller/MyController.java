package com.uhg.tanmay.particle.api.controller;
import com.uhg.tanmay.particle.api.entity.Particle;
import com.uhg.tanmay.particle.api.entity.SParticle;
import com.uhg.tanmay.particle.api.service.ParticleService;
import com.uhg.tanmay.particle.api.service.SaleParticleService;
import com.uhg.tanmay.particle.api.wrappers.GetWrapper;
import com.uhg.tanmay.particle.api.wrappers.TotalWrapper;
import com.uhg.tanmay.particle.api.wrappers.Wrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MyController {
    @Autowired
    ParticleService service;
    @Autowired
    SaleParticleService ss;

    // Swagger ui mapping
    @RequestMapping(method = RequestMethod.GET, value = "/ui")
    public RedirectView redirects(){

        return new RedirectView("/swagger-ui/index.html");
    }

    // Api documentation mapping
    @RequestMapping(method = RequestMethod.GET, value = "/doc")
    public RedirectView redirectsToDocs(){

        return new RedirectView("/v3/api-docs");
    }

    // home mapping
    String newLine = System.getProperty("line.separator");
    @RequestMapping(method = RequestMethod.GET, value = " ")
    public String redirectsToHome(){
        return "Welcome to the particle stock exchange" + newLine + "We will help you out here" +
                newLine + "" + newLine + "1. You can access swagger ui by adding /ui to the local host" +
                newLine + "2. To access documentation use /doc" +
                newLine + "3. To access info on current available particles use /particle" +
                newLine + "2. To access complete particle details use /particle/details" +
                newLine + "2. To access documentation use /doc";
    }


    /* Beginning of GET mapping */

    @RequestMapping( method = RequestMethod.GET ,value = "/particle")
    ArrayList<GetWrapper> gets(){
        return service.getsNecessaryParticles();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/details")
    ArrayList<Particle> getsAll(){
        return service.getsParticles();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/total")
    ArrayList<TotalWrapper> total(){
        return service.getTotals();
    }


    @RequestMapping( method = RequestMethod.GET ,value = "/particle/sales")
    ArrayList<Wrapper> getsSales(){
        return ss.onlySales();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/sales/details")
    ArrayList<SParticle> getsFullSales(){
        return ss.getFullSales();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/sales/total")
    ArrayList<TotalWrapper> getsTotals(){
        return ss.totals();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/filter/price")
    ArrayList<Particle> PriceFilter(){
        return service.filterPrice();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/filter/quantity")
    ArrayList<Particle> QuantityFilter(){
        return service.filterQuantity();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/filter/charge")
    ArrayList<Particle> ChargeFilter(){
        return service.filterCharge();
    }


    /* Beginning of POST mapping */

    // POST inventories
    @RequestMapping( method = RequestMethod.POST ,value = "/particle")
    String puts(@RequestBody ArrayList<Wrapper> list){
        int flag = 0;
        for(Wrapper wrap : list){
            if (service.getByTid(wrap.getTid())){
                ArrayList<Particle> plist = service.getAllByTid(wrap.getTid());
                for(Particle p : plist){
                    if (p.getPrice() == wrap.getPrice()){
                        service.updateAdd(wrap.getTid(), wrap.getPrice(), wrap.getQuantity());
                        flag = 1;
                    }
                }
            }

            if (flag == 0){
                service.putParticles(wrap);
            }
        }
        return "Save Successful";
    }

    // POST sales
    @RequestMapping(method = RequestMethod.POST ,value = "/particle/sales")
    String postSales(@RequestBody ArrayList<Wrapper> wraps) {
        for (Wrapper wrap : wraps){
            ArrayList<Particle> tmp = service.getAllByTidAndPrice(wrap.getTid(), wrap.getPrice(), wrap.getQuantity());
            if(tmp.size() == 0){
                return "No stock of given specifications exist / Check with inventory and then proceed with the sale";
            }

            ArrayList<Wrapper> tmpp = ss.onlySales();
            int flag = 0;
            for(Wrapper w : tmpp){
                if (w.getTid() == wrap.getTid()){
                    ss.updateSale(wrap.getTid(), wrap.getQuantity());
                    service.update(wrap.getTid(), wrap.getPrice(), wrap.getQuantity());
                    flag = 1;
                    break; }
            }
            if (flag == 0){
                ss.postParticle(wrap);
                service.update(wrap.getTid(), wrap.getPrice(), wrap.getQuantity());
            }
        }
        return "SUCCESSFUL";
    }


    /* Beginning of PUT mapping */

    // UPDATE price of an inventory particle
    @RequestMapping( method = RequestMethod.PUT ,value = "/particle/price")
    String Puts(@RequestBody ArrayList<Wrapper> wraps){
        for(Wrapper wrap : wraps){
            service.putsPrice(wrap);
        }
        return "SUCCESSFUL";
    }

    /* Beginning of DELETE mapping */

    @RequestMapping(method = RequestMethod.DELETE, value = "/particle")
    String resetInventory(){
        service.reset();
        return "Inventory reset Successful";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/particle/sales")
    String resetSales(){
        ss.reset();
        return "Sales reset Successful";
    }



}
