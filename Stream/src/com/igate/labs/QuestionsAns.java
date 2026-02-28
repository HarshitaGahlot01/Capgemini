package com.igate.labs;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionsAns {
	public static void main(String args[]) {
	 List<Owner> list = CarRepository.getOwners();
     List<Car> allCars = CarRepository.getCars();
     List<String> result =
             list.stream()
                     .filter(o -> o.getCars() == null || o.getCars().isEmpty())
                     .map(Owner::getName)
                     .collect(Collectors.toList());

     System.out.println(result);
     
     Map<String,Integer> map =
             list.stream()
                     .collect(Collectors.toMap(
                             Owner::getName,
                             o -> o.getCars()==null ? 0 : o.getCars().size()
                     ));

     map.forEach((a,b)-> System.out.println(a+" -> "+b));     
     Set<Car> ownedCars =
             list.stream()
                     .filter(o -> o.getCars()!=null)
                     .flatMap(o -> o.getCars().stream())
                     .collect(Collectors.toSet());
     List<Car> notOwnedCars =
             allCars.stream()
                     .filter(c -> !ownedCars.contains(c))
                     .collect(Collectors.toList());

     notOwnedCars.forEach(System.out::println);
 }

 }

     
 


	


