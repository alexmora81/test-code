@RestController
public class WeatherApiRestController {

@Autowired
private WeatherRepository repository;

@PostMapping("/weather")
public ResponseEntity<Weather> saveRecord(@RequestBody Weather newWeatherRecord){
return new ResponseEntity<>(repository.save(newWeatherRecord),HttpStatus.CREATED);
}
@GetMapping("/weather")
public ResponseEntity<List<Weather>> getAllRecords(){
  return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
}
@GetMapping("/weather/{id}")
public ResponseEntity<Weather> getOneRecord(@PathVariable String id){
  int idInt = Integer.parseInt(id);
  return new ResponseEntity<>(repository.getById(idInt),HttpStatus.OK);
}

@DeleteMapping("/weather/{id}")
public ResponseEntity<Weather> deleteOneRecord(@PathVariable String id){
  int idInt = Integer.parseInt(id);
  repository.deleteById(idInt);
  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
