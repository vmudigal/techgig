/**

 As a commander of an army battalion, you have to plan the attack on some enemy cities which are connected by road-network. Before starting the attack, you have information about all the cities and roads connecting them. You can start attack from any city but you must travel from one city to another via roads only. To prevent enemy re-enforcement and block transport through a city, you reach there, destroy it and burn it while leaving behind. This makes it impossible for you to return to a city (via any road) destroyed by you in past. 

 Given a list of all the roads (each connecting a pair of cities), you have to tell what is the maximum number of cities that can be destroyed by the strategy mentioned above. (you can assume that number of cities is 0<=number of cities<=1000 )
 Input/Output Specifications Input Specification:

 List of all the roads{ list of pairs x#y which denotes that there exists a direct road from city "x" to city "y" } 

 Input Specification:

 The maximum number of cities that can be destroyed


 Examples

 1,2,3,11,4,12,8,9,10

 Input: {1#2,2#3,1#11,3#11,4#11,4#5,5#6,5#7,6#7,4#12,8#12,9#12,8#10,9#10,8#9}

 Output: 9

 */
package techgig.armyBattalionProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateCode {

	/****************************************
	 * 
	 * maxno_city
	 * 
	 * @param input1
	 * @return
	 *
	 ****************************************/
	public int maxno_city(String[] input1) {
		int index = 0;
		try {
			List<CityMapping> cityMappings = new ArrayList<CandidateCode.CityMapping>();
			for (String input : input1) {
				String[] splitValue = input.split("#");
				CityMapping cm = new CityMapping();
				cm.setIndex(index++);
				cm.setFrom(Integer.parseInt(splitValue[0]));
				cm.setTo(Integer.parseInt(splitValue[1]));
				cityMappings.add(cm);
			}
			// Recursively Calculate Max Cities To Be Destroyed
			Set<String> cities = new HashSet<String>();
			for (int i = 0; i < cityMappings.size(); i++) {
				List<Integer> visited = new ArrayList<Integer>();
				String city = new String();
				Set<String> partitalCities = calMaxCities(0, i, cityMappings, cities, city,
						visited);
				cities.addAll(partitalCities);
			}
			int max = 0;
			for (String maxCity : cities) {
				String [] maxCities = maxCity.split("#");
				int maxCityLength = maxCities.length;
				if (max < maxCityLength) {
					max = maxCityLength;
				}
			}
			return max;
		} catch (Exception ex) {
			return 0;
		}
	}

	private static Set<String> calMaxCities(int prevCity, int index,
			List<CityMapping> cityMappings, Set<String> cities, String city,
			List<Integer> visited) {

		if (visited.isEmpty()) {
			if (cityMappings.get(index).getTo() != cityMappings.get(index).getFrom()) {
				city = cityMappings.get(index).getFrom() + "#"
						+ cityMappings.get(index).getTo();
				visited.add(cityMappings.get(index).getFrom());
				visited.add(cityMappings.get(index).getTo());
				prevCity = cityMappings.get(index).getTo();
			} else {
				city = cityMappings.get(index).getFrom() + "";
				visited.add(cityMappings.get(index).getFrom());
				prevCity = cityMappings.get(index).getFrom();
			}
		} else {
			if (prevCity == cityMappings.get(index).getFrom()) {
				city = city + "#" + cityMappings.get(index).getTo();
				visited.add(cityMappings.get(index).getTo());
				prevCity = cityMappings.get(index).getTo();
			} else if (prevCity == cityMappings.get(index).getTo()) {
				city = city + "#" + cityMappings.get(index).getFrom();
				visited.add(cityMappings.get(index).getFrom());
				prevCity = cityMappings.get(index).getFrom();
			}
		}
		List<CityMapping> pathsFromCity = findPathFromCity(prevCity,
				cityMappings, visited);
		for (CityMapping cityMapping : pathsFromCity) {
			calMaxCities(prevCity, cityMapping.getIndex(), cityMappings,
					cities, city, visited);
		}
		cities.add(city);
		visited = new ArrayList<Integer>();
		return cities;
	}

	private static List<CityMapping> findPathFromCity(int prevCity,
			List<CityMapping> cityMappings, List<Integer> visited) {
		List<CityMapping> pathsFromCity = new ArrayList<CandidateCode.CityMapping>();
		for (CityMapping cityMapping : cityMappings) {
			if (prevCity == cityMapping.getFrom()
					&& !visited.contains(cityMapping.getTo())) {
				pathsFromCity.add(cityMapping);
			} else if (prevCity == cityMapping.getTo()
					&& !visited.contains(cityMapping.getFrom())) {
				pathsFromCity.add(cityMapping);
			}
		}
		return pathsFromCity;
	}
	
	private static class CityMapping {
		private int index;
		private int from;
		private int to;

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getFrom() {
			return from;
		}

		public void setFrom(int from) {
			this.from = from;
		}

		public int getTo() {
			return to;
		}

		public void setTo(int to) {
			this.to = to;
		}

		@Override
		public String toString() {
			return getFrom() + "#" + getTo();
		}
	}
}