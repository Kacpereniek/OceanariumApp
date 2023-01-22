package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.awt.print.Printable;
import java.util.List;
import java.util.Queue;

@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");


        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/okazy_admin").setViewName("admin/okazy_admin");
        registry.addViewController("/pracownicy_admin").setViewName("admin/pracownicy_admin");
        registry.addViewController("/bilety_admin").setViewName("admin/bilety_admin");
        registry.addViewController("/zbiorniki_admin").setViewName("admin/zbiorniki_admin");

        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/okazy_user").setViewName("user/okazy_user");
        registry.addViewController("/pracownicy_user").setViewName("user/pracownicy_user");
        registry.addViewController("/bilety_user").setViewName("user/bilety_user");
        registry.addViewController("/zbiorniki_user").setViewName("user/zbiorniki_user");

    }


    @Controller
    public class DashboardController {


        @RequestMapping("/index")
        public String viewHomePage(Model model) {
            return "index";
        }


        @Autowired
        private OkazyDAO dao2;


        @RequestMapping("/okazy_admin")
        public String viewOkazyAdminPage(Model model) {
            List<Okazy> listOkazy = dao2.list();
            model.addAttribute(("listOkazy"), listOkazy);
            return "admin/okazy_admin";
        }

        @RequestMapping("/okazy_user")
        public String viewOkazyUserPage(Model model) {
            List<Okazy> listOkazy = dao2.list();
            model.addAttribute(("listOkazy"), listOkazy);
            return "user/okazy_user";
        }

        @RequestMapping("/newokaz_admin/{id_gatunku}")
        public String showNewOkazPage(@PathVariable("id_gatunku") int id_gatunku, Model model) {
            Okazy okazy = new Okazy();
            okazy.setId_gatunku(String.valueOf(id_gatunku));
            model.addAttribute("okazy", okazy);
            return "admin/newokaz_admin";
        }

        @RequestMapping(value = "/saveokaz_admin", method = RequestMethod.POST)
        public String save(@ModelAttribute("okazy") Okazy okazy) {
            dao2.save(okazy);
            return "redirect:/okazy_admin";
        }

        @RequestMapping("/editokaz/{id_okazu}")
        public ModelAndView showEditOkazPage(@PathVariable(name = "id_okazu") int id) {
            ModelAndView mav = new ModelAndView("admin/editokaz_admin");
            Okazy okazy = dao2.get(id);
            mav.addObject("okazy", okazy);

            return mav;
        }

        @RequestMapping(value = "/updateokaz_admin", method = RequestMethod.POST)
        public String updateOkaz(@ModelAttribute("okazy") Okazy okazy) {
            dao2.update(okazy);

            return "redirect:/okazy_admin";
        }

        @RequestMapping("/deleteokaz/{id_okazu}")
        public String deleteOkaz(@PathVariable(name = "id_okazu") int id) {
            dao2.delete(id);

            return "redirect:/okazy_admin";
        }


        @Autowired
        private PracownicyDAO dao4;

        @RequestMapping("/pracownicy_admin")
        public String viewPracownicyAdminPage(Model model) {
            List<Pracownicy> listPracownicy = dao4.list();
            model.addAttribute(("listPracownicy"), listPracownicy);
            return "admin/pracownicy_admin";
        }

        @RequestMapping("/newpracownik_admin/{id_adresu}")
        public String showNewPracownikPage(@PathVariable("id_adresu") String id_adresu, Model model) {
            Pracownicy pracownicy = new Pracownicy();
            pracownicy.setId_oceanarium(1);
            pracownicy.setId_adresu(id_adresu);
            model.addAttribute("pracownicy", pracownicy);
            return "admin/newpracownik_admin";
        }

        @RequestMapping(value = "/savepracownik_admin", method = RequestMethod.POST)
        public String save(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
            dao4.save(pracownicy);
            return "redirect:/pracownicy_admin";
        }

        @RequestMapping("/editpracownik/{id_pracownika}")
        public ModelAndView showEditPracownikPage(@PathVariable(name = "id_pracownika") int id) {
            ModelAndView mav = new ModelAndView("admin/editpracownik_admin");
            Pracownicy pracownicy = dao4.get(id);
            mav.addObject("pracownicy", pracownicy);

            return mav;
        }
        @RequestMapping("/editpracownik/9")
        public ModelAndView showEditPracownik2Page(@PathVariable(name = "id_pracownika") int id) {
            ModelAndView mav = new ModelAndView("user/editpracownik_user");
            Pracownicy pracownicy = dao4.get(id);
            mav.addObject("pracownicy", pracownicy);

            return mav;
        }

        @RequestMapping(value = "/updatepracownik_admin", method = RequestMethod.POST)
        public String updatePracownik(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
            dao4.update(pracownicy);

            return "redirect:/pracownicy_admin";
        }

        @RequestMapping("/deletepracownik/{id_pracownika}")
        public String deletePracownik(@PathVariable(name = "id_pracownika") int id) {
            dao4.delete(id);

            return "redirect:/pracownicy_admin";
        }


        @Autowired
        private BiletyDAO dao5;

        @RequestMapping("/bilety_admin")
        public String viewBiletyAdminPage(Model model) {
            List<Bilety> listBilety = dao5.list();
            model.addAttribute(("listBilety"), listBilety);
            return "admin/bilety_admin";
        }

        @RequestMapping("/bilety_user")
        public String viewBiletyUserPage(Model model) {
            List<Bilety> listBilety = dao5.list();
            model.addAttribute(("listBilety"), listBilety);
            return "user/bilety_user";
        }

        @RequestMapping("/newbilet_admin")
        public String showNewBiletPage(Model model) {
            Bilety bilety = new Bilety();
            model.addAttribute("bilety", bilety);
            return "admin/newbilet_admin";
        }

        @RequestMapping("/newbilet_user")
        public String showNewBiletPage2(Model model) {
            Bilety bilety = new Bilety();
            model.addAttribute("bilety", bilety);
            return "user/newbilet_user";
        }

        @RequestMapping(value = "/savebilet_user", method = RequestMethod.POST)
        public String save(@ModelAttribute("bilety") Bilety bilety) {
            dao5.save(bilety);
            return "redirect:/newbilet_user";
        }
        @RequestMapping(value = "/savebilet_admin", method = RequestMethod.POST)
        public String save2(@ModelAttribute("bilety") Bilety bilety) {
            dao5.save(bilety);
            return "redirect:/bilety_admin";
        }
        @RequestMapping(value = "/updatebilet_admin", method = {RequestMethod.POST})
        public String update(@ModelAttribute("bilety") Bilety bilety) {
            dao5.update(bilety);

            return "redirect:/bilety_admin";
        }

        @RequestMapping("/editbilet/{id_bilet}")
        public ModelAndView showEditBiletPage(@PathVariable(name = "id_bilet") int id) {
            ModelAndView mav = new ModelAndView("admin/editbilet_admin");
            Bilety bilety = dao5.get(id);
            mav.addObject("bilety", bilety);

            return mav;
        }



        @RequestMapping("/deletebilet/{id_bilet}")
        public String deleteBilet(@PathVariable(name = "id_bilet") int id) {
            dao5.delete(id);

            return "redirect:/bilety_admin";
        }


        @Autowired
        private AdresyDAO dao6;


        @RequestMapping("/newadres_admin")
        public String showNewAdresPage(Model model) {
            Adresy adresy = new Adresy();
            model.addAttribute("adresy", adresy);
            return "admin/newadres_admin";
        }

        @RequestMapping(value = "/saveadres_admin", method = {RequestMethod.POST})
        public String save(@ModelAttribute("adresy") Adresy adresy) {
            dao6.save(adresy);
            List<Adresy> listaAdresow = dao6.list();
            Adresy adres = listaAdresow.get(0);
            String str = Integer.toString(Integer.parseInt(adres.getId_adresu()));
            System.out.println(listaAdresow.get(0).getId_adresu());

            return "redirect:/newpracownik_admin/" + str;
        }

        @RequestMapping("/editadres/{id_adresu}")
        public ModelAndView showEditAdresPage(@PathVariable(name = "id_adresu") int id) {
            ModelAndView mav = new ModelAndView("admin/editadres_admin");
            Adresy adresy = dao6.get(id);
            mav.addObject("adresy", adresy);

            return mav;
        }


        @RequestMapping(value = "/updateadres_admin", method = RequestMethod.POST)
        public String update(@ModelAttribute("adresy") Adresy adresy) {
            dao6.update(adresy);

            return "redirect:/pracownicy";
        }


        @Autowired
        private GatunkiDAO dao8;


        @RequestMapping("/newgatunek_admin")
        public String showNewGatunekPage(Model model) {
            Gatunki gatunki = new Gatunki();
            model.addAttribute("gatunki", gatunki);
            return "admin/newgatunek_admin";
        }


        @RequestMapping(value = "/savegatunek_admin", method = {RequestMethod.POST})
        public String save(@ModelAttribute("gatunki") Gatunki gatunki) {
            dao8.save(gatunki);
            List<Gatunki> listaGatunkow = dao8.list();
            Gatunki gatunek = listaGatunkow.get(0);
            String str = String.valueOf(listaGatunkow.get(0).getId_gatunku());

            return "redirect:/newokaz_admin/" + str;
        }


        @RequestMapping("/editgatunek/{id_gatunku}")
        public ModelAndView showEditGatunekPage(@PathVariable(name = "id_gatunku") int id) {
            ModelAndView mav = new ModelAndView("admin/editgatunek_admin");
            Gatunki gatunki = dao8.get(id);
            mav.addObject("gatunki", gatunki);

            return mav;
        }


        @RequestMapping(value = "/updategatunek_admin", method = {RequestMethod.POST})
        public String update(@ModelAttribute("gatunki") Gatunki gatunki) {
            dao8.update(gatunki);

            return "redirect:/okazy_admin";
        }

        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/main_user/9";
            } else {
                return "redirect:/index";
            }
        }
        @RequestMapping("/pracownicy")
        public String pracownicy2(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/pracownicy_admin";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/editpracownik_user/9";
            } else {
                return "redirect:/index";
            }
        }
        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }

        @RequestMapping(value = "/updatepracownik_user", method = RequestMethod.POST)
        public String updateUserData(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
            dao4.update(pracownicy);

            String idString = Integer.toString(pracownicy.getId_pracownika());

            return "redirect:/editpracownik_user/9";
        }
        @RequestMapping("/editpracownik_user/{idKlienta}")
        public ModelAndView showEditUserDataPage(@PathVariable(name = "idKlienta") int id) {
            ModelAndView mav = new ModelAndView("user/editpracownik_user");

            Pracownicy pracownicy = dao4.get(id);
            mav.addObject("pracownicy", pracownicy);

            return mav;
        }
        @RequestMapping(value = "/main_user/{idKlienta}")
        public ModelAndView showUserPage(Model model, @PathVariable(name = "idKlienta") int id) {
            ModelAndView mav = new ModelAndView("user/main_user");

            Pracownicy pracownicy = dao4.get(id);
            mav.addObject(pracownicy);

            return mav;
        }



    }


}