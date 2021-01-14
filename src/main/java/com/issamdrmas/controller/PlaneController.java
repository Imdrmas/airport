package com.issamdrmas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.issamdrmas.model.Plane;
import com.issamdrmas.repostory.FlightRepisotory;
import com.issamdrmas.repostory.PilotRepisotory;
import com.issamdrmas.repostory.PlaneRepisotory;
import com.issamdrmas.model.Pilot;
import com.issamdrmas.model.Flight;

@Controller
public class PlaneController {

	@Autowired
	PilotRepisotory pilotRepisotory;

	@Autowired
	PlaneRepisotory planeRepisotory;

	@Autowired
	FlightRepisotory flightRepisotory;

	@GetMapping(value = ("/admin/form"))
	public String formAvion(Model model) {

		model.addAttribute("pilot", new Pilot());
		List<Pilot> pilots = pilotRepisotory.findAll();
		model.addAttribute("pilots", pilots);

		model.addAttribute("plane", new Plane());
		List<Plane> planes = planeRepisotory.findAll();
		model.addAttribute("avions", planes);

		model.addAttribute("planes", planes);
		model.addAttribute("pilots", pilots);
		model.addAttribute("flight", new Flight());
		return "form";
	}

	@PostMapping(value = "/admin/savePilot")
	public String savePilot(Pilot pilot, BindingResult b) {
 
		if (b.hasErrors())
			return "form";
		pilotRepisotory.save(pilot);
		return "confirm";

	}

	@PostMapping(value = "/admin/savePlane")
	public String savePlane(Plane plane, BindingResult b) {
		if (b.hasErrors())
			return "form";
		planeRepisotory.save(plane);
		return "confirm";
	}

	@PostMapping(value = "/admin/saveFlight")
	public String saveFlight(Flight flight, BindingResult b) {
		if (b.hasErrors())
			return "form";
		flightRepisotory.save(flight);
		return "confirm";
	}

	@RequestMapping(value = "/admin/editPilot", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public String editPilot(Model model, Long id) {
		Optional<Pilot> pilot = pilotRepisotory.findById(id);
		if (pilot.isPresent()) {
			Pilot pilot2 = pilot.get();
			
			Long idExists = pilot2.getId();
			String nameString = pilot2.getName();
			String siteString = pilot2.getSite();
			String codeString = pilot2.getCode();

			model.addAttribute("idExists", idExists);
			model.addAttribute("nameString", nameString);
			model.addAttribute("siteString", siteString);
			model.addAttribute("codeString", codeString);
			

	}
		return "editPilot";

	}

	@RequestMapping(value = "/admin/deletePilot", method = { RequestMethod.GET, RequestMethod.POST })
	public String deletePilot(Model model, long id) {
		pilotRepisotory.deleteById(id);
		return "confirmdel";

	}

	@RequestMapping(value = "/admin/editPlane", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public String editPlane(Model model, @RequestParam(name = "id", defaultValue = "") Long id) {
		Optional<Plane> planeOptional = planeRepisotory.findById(id);
		if (planeOptional.isPresent()) {
			Plane plane = planeOptional.get();

			Long idExists = plane.getId();
			String code = plane.getCode();
			String constructor = plane.getConstructor();
			String modal = plane.getModel();
			String site = plane.getSite();
			int capacity = plane.getCapacity();

			model.addAttribute("idExists", idExists);
			model.addAttribute("code", code);
			model.addAttribute("constructor", constructor);
			model.addAttribute("modal", modal);
			model.addAttribute("site", site);
			model.addAttribute("capacity", capacity);

		}
		return "editPlane";

	}

	@RequestMapping(value = "/admin/deleteFlight", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteFlight(long id) {
		flightRepisotory.deleteById(id);
		return "confirmdel";

	}

	@RequestMapping(value = "/admin/editFlight", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
	public String editFlight(Model model, Long id) {
		Optional<Flight> flight = flightRepisotory.findById(id);
		if (flight.isPresent()) {
			Flight flight2 = flight.get();
			Long idExists = flight2.getId();
			String code = flight2.getCode();
			String timeArrival = flight2.getTimeArrival();
			String departureTime = flight2.getDepartureTime();
			String arrivalSite = flight2.getArrivalSite();
			String siteDepart = flight2.getSiteDepart();

			String pilotCode = flight2.getPilotCode();
			String planeCode = flight2.getPlaneCode();

			model.addAttribute("pilotCode", pilotCode);
			model.addAttribute("planeCode", planeCode);

			model.addAttribute("idExists", idExists);
			model.addAttribute("code", code);
			model.addAttribute("timeArrival", timeArrival);
			model.addAttribute("departureTime", departureTime);
			model.addAttribute("arrivalSite", arrivalSite);
			model.addAttribute("siteDepart", siteDepart);

			List<Pilot> pilots = pilotRepisotory.findAll();
			model.addAttribute("pilots", pilots);

			List<Plane> planes = planeRepisotory.findAll();
			model.addAttribute("planes", planes);

		}
		model.addAttribute("flight", flight);
		return "editFlight";

	}

	@RequestMapping(value = "/admin/deletePlane", method = { RequestMethod.GET, RequestMethod.POST })
	public String deletePlane(Model model, Long id) {
		planeRepisotory.deleteById(id);
		return "confirmdel";

	}

	@RequestMapping(value = "/")
	public String home(Model model) {

		List<Pilot> listPilots = pilotRepisotory.findAll();
		model.addAttribute("listPilots", listPilots);

		List<Plane> listPlanes = planeRepisotory.findAll();
		model.addAttribute("listPlanes", listPlanes);

		List<Flight> listFlights = flightRepisotory.findAll();
		model.addAttribute("listFlights", listFlights);
		return "index";
	}

	@GetMapping(value = "/pilot")
	public String getMyVol(Model model, @RequestParam(name = "code", defaultValue = "") String code) {

		List<Flight> listFlights = flightRepisotory.getPiloteCode("%" + code + "%");
		model.addAttribute("listFlights", listFlights);
		return "pilot";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/404")
	public String accessDneied() {
		return "404";
	}

}
