package it.univaq.aycs.presentation;


import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.univaq.aycs.business.AYCService;
import it.univaq.aycs.common.spring.security.JWTTokenUtil;
import it.univaq.aycs.common.spring.security.UserDetailsImpl;
import it.univaq.aycs.domain.Utente;

@RestController
@RequestMapping("/api")
public class RESTUtenteController {

	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private AYCService aycService;

	@PostMapping("/login")
	public UtenteResponse login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws AuthenticationException {
		// Effettuo l'autenticazione
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Genero Token e lo inserisco nell'header di risposta
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String token = jwtTokenUtil.generateToken(userDetails);
		System.out.print("token:"+token);
		response.setHeader(tokenHeader, token);
		
		// Ritorno l'utente
		return new UtenteResponse(((UserDetailsImpl) userDetails).getUtente());
	}

	@PostMapping("/utente/updateprofilo")
	public UtenteResponse updateProfilo(@RequestBody Utente utente) {
		Utente nuovoUtente = aycService.updateProfilo(utente);		
		return new UtenteResponse(nuovoUtente);
	}
	
	@PostMapping("/sign")
	public void createUtente(@RequestBody Utente utente) {
		aycService.createUtente(utente);
	}

	
}
