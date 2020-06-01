package weekthree.taxipark


/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> {
    val list = allDrivers.toMutableSet()
    trips.forEach {
        if (list.contains(it.driver)) {
            list.remove(it.driver)
        }
    }
    return list
}

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> {
    var list = mutableSetOf<Passenger>()
    allPassengers.forEach { passenger ->
        var passengerTrips = 0
        trips.forEach { trips ->
            if (trips.passengers.contains(passenger)) {
                passengerTrips++
            }
        }
        if (minTrips <= passengerTrips) list.add(passenger)
    }

    return list
}


/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> {
    var count = 0
    var list = allPassengers.associate { Pair(it, 0) }.toMutableMap()

    trips.forEach { trip ->
        if (trip.driver == driver) {
            trip.passengers.forEach { passenger ->
                count = list[passenger]!!.plus(1)
                list.put(passenger, count)

            }
        }
    }

    var result = mutableSetOf<Passenger>()
    list.forEach {
        if (it.value > 1) result.add(it.key)
    }

    return result
}


/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    var count = 0
    var list = allPassengers.associate { Pair(it, 0) }.toMutableMap()

    trips.forEach { trip ->
        trip.passengers.forEach { passenger ->
            if (trip.cost < trip.distance + trip.duration) {
                count = list[passenger]!!.plus(1)
            } else {
                count = list[passenger]!!.minus(1)
            }
            list.put(passenger, count)
        }
    }

    var result = mutableSetOf<Passenger>()
    list.forEach {
        if (it.value > 0) result.add(it.key)
    }

    return result
}


/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {

    if (trips.isEmpty()) return null

    var list = mutableMapOf<IntRange, MutableList<Passenger>>()
    var rest = 0
    var maxRange = 0
    var minRange = 0

    trips.forEach {
        rest = it.duration % 10
        minRange = it.duration - rest
        maxRange = minRange + 9
        if (list.containsKey(minRange..maxRange)) {
            list[minRange..maxRange]?.addAll(it.passengers.toMutableList())
        } else {
            list.put(minRange..maxRange, it.passengers.toMutableList())
        }
    }

    var max = 0
    var range: IntRange = IntRange(0, 0)

    list.forEach {
        println("$max   ${it.key}  ${it.value.size}")
        if (max < it.value.size) {
            max = it.value.size
            range = it.key
        }
    }

    return range
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {

    if (trips.isEmpty()) return false

    var totalCost = 0.0
    var map = allDrivers.associate { Pair(it, 0.0) }.toMutableMap()
    trips.forEach {
        totalCost += it.cost
        map[it.driver] = map[it.driver]!!.plus(it.cost)
    }

    val list = map.toList().sortedBy { it.second }
    var twenty: Int = (allDrivers.size * 0.2).toInt()
    var twentyTotalCost = 0.0
    for (i in list.lastIndex downTo (list.lastIndex - twenty + 1)) {
        twentyTotalCost += list[i].second
    }

    return twentyTotalCost >= totalCost * 0.8
}