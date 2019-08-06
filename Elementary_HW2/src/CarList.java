import java.util.*;

public class CarList {

    Map<String, Car> carList = new HashMap<>();

    public Car createCar() {

        Scanner sc = new Scanner(System.in);
        String vin, reg, brand, model;
        short year;
        int mileage;
        System.out.println("Введите VIN-код автомобиля");
        vin = sc.nextLine();
        System.out.println("Введите регистрационный номер автомобиля:");
        reg = sc.nextLine();
        System.out.println("Введите марку автомобиля:");
        brand = sc.nextLine();
        System.out.println("Введите модель автомобиля:");
        model = sc.nextLine();
        System.out.println("Введите год выпуска автомобиля:");
        year = sc.nextShort();
        System.out.println("Введите пробег автомобиля:");
        mileage = sc.nextInt();
        Car newCar = new Car(vin, reg, brand, model, year, mileage);
        return newCar;
    }

    public void addCar() {
        System.out.println("Для добавления нового автомобиля в базу данных, необходимо ввести данные.");
        Car car = createCar();
        carList.put(car.getVin(), car);
        System.out.println("Автомобиль с регистрационным номером " + car.getRegNumber() + " был успешно добавлен в базу данных");
    }

    public void editCar() {
        System.out.println("Для редактирования информации об автомобиле введите VIN-код (либо введите 0, чтобы вернуться в меню):");
        String regNumber;
        Car editedCar;
        boolean wasEdited = false;
        Scanner sc = new Scanner(System.in);
        regNumber = sc.nextLine();
        if (!regNumber.equals("0")) {
            if (carList.containsKey(regNumber)) {
                System.out.println("В базе данных найдена машина с указанным VIN-кодом. Переходим к обновлению информации");
                carList.remove(regNumber);
                editedCar = createCar();
                carList.put(editedCar.getVin(), editedCar);
                wasEdited = true;
                editCar();
            }
            if (!wasEdited) {
                System.out.println("Автомобиль с указанным VIN-кодом отсутствует в базе данных");
                editCar();
            }
        } else {
            return;
        }
    }

    public void removeCar() {
        System.out.println("Для удаления информации об автомобиле введите VIN-код (либо введите 0, чтобы вернуться в меню:");
        String regNumber;
        boolean wasDeleted = false;
        Scanner sc = new Scanner(System.in);
        regNumber = sc.nextLine();
        if (!regNumber.equals("0")) {
            if (carList.containsKey(regNumber)) {
                System.out.println("В базе данных найдена машина с указанным VIN-кодом. Переходим к удалению информации");
                carList.remove(regNumber);
                wasDeleted = true;
                removeCar();

            }
            if (!wasDeleted) {
                System.out.println("Автомобиль с указанным VIN-кодом отсутствует в базе данных");
                removeCar();
            }
        } else {
            return;
        }
    }

    public void removeAllCars () {
        carList.clear();
        System.out.println("Вся информация была удалена из базы данных");
    }

    public void removeByYear () {
        System.out.println("Для удаления информации об автомобиле по году выпуска введите год выпуска, с которого хотите начать удаление (либо введите 0, чтобы вернуться в меню):");
        short lowerYear, upperYear;
        Scanner sc = new Scanner(System.in);
        lowerYear = sc.nextShort();
        if (lowerYear != 0) {
            System.out.println("Теперь введите год, на котором хотите завершить удаление:");
            upperYear = sc.nextShort();
            for (String vin : carList.keySet()) {
                Car car = carList.get(vin);
                if ((car.getYear() >= lowerYear) && (car.getYear() <= upperYear)) {
                    carList.remove(vin);
                }
            }
            removeByYear();
        } else {
            return;
        }

    }

    public void searchCarByVIN() {
        System.out.println("Для нахождения информации об автомобиле по VIN-коду введите VIN-код (либо введите 0, чтобы вернуться в меню)");
        String regNumber;
        boolean wasFound = false;
        Scanner sc = new Scanner(System.in);
        regNumber = sc.nextLine();
        if (!regNumber.equals("0")) {
            if (carList.containsKey(regNumber)) {
                System.out.println("В базе данных найдена машина с указанным VIN-кодом.");
                wasFound = true;
                searchCarByVIN();

            }
            if (!wasFound) {
                System.out.println("Автомобиль с указанным VIN-кодом отсутствует в базе данных");
                searchCarByVIN();
            }
        } else {
            return;
        }
    }

    public void searchCarByRegNum() {
        System.out.println("Для нахождения информации об автомобиле по регистрационному номеру введите регистрационный номер (либо введите 0, чтобы вернуться в меню)");
        String regNumber;
        boolean wasFound = false;
        Scanner sc = new Scanner(System.in);
        regNumber = sc.nextLine();
        if (!regNumber.equals("0")) {
            for (String vin: carList.keySet()) {
                Car car = carList.get(vin);
                if (car.getRegNumber().equals(regNumber)) {
                    System.out.println("В базе данных найдена машина с указанным регистрационным номером.");
                    wasFound = true;
                    searchCarByRegNum();
                }
            }
            if (!wasFound) {
                System.out.println("Автомобиль с указанным регистрационным номером отсутствует в базе данных");
                searchCarByRegNum();
            }
        } else {
            return;
        }
    }

    public void showCarList(CarList carDataBase) {
        if (carDataBase.carList.size() == 0) {
            System.out.println("Нет данных для отображения!");
        } else {
            System.out.println("По данному запросу найдены следующие автомобили");
            System.out.println("  VIN-код   Рег. №   Марка   Модель  Год выпуска  Пробег");
            int i = 0;
            for (String vin : carList.keySet()) {
                Car car = carList.get(vin);
                System.out.print(i + 1 + ". " + car.getVin() + "\t");
                System.out.print(car.getRegNumber() + "\t");
                System.out.print(car.getBrand() + "\t");
                System.out.print(car.getModel() + "\t");
                System.out.print(car.getYear() + "\t");
                System.out.print(car.getMileage() + "\t");
                System.out.println();
            }
        }
    }

    public void searchCarByMarkAndModel() {
        CarList searchResult = new CarList();
        String brand, model;
        Scanner sc = new Scanner(System.in);
        System.out.println("Для поиска автомобиля по марке и модели введите марку (либо введите 0, чтобы вернуться в меню):");
        brand = sc.nextLine();
        if (!brand.equals("0")) {
            System.out.println("Теперь введите модель:");
            model = sc.nextLine();
            for(String vin: carList.keySet()) {
                Car car = carList.get(vin);
                if (car.getBrand().equals(brand) && (car.getModel().equals(model))) {
                    searchResult.carList.put(car.getVin(),car);
                }
            }
            searchResult.showCarList(searchResult);
            searchCarByMarkAndModel();
        } else {
            return;
        }
    }

    public void searchCarByYearRange() {
        CarList searchResult = new CarList();
        short lowerYear, upperYear;
        Scanner sc = new Scanner(System.in);
        System.out.println("Для поиска автомобиля по году выпуска введите год, с которого хотите начать фильтр (либо введите 0, чтобы вернуться в меню):");
        lowerYear = sc.nextShort();
        if (lowerYear != 0) {
            System.out.println("Теперь введите год, которым хотите завершить фильтр:");
            upperYear = sc.nextShort();
            for (String vin: carList.keySet()) {
                Car car = carList.get(vin);
                if (car.getYear() >= lowerYear && (car.getYear() <= upperYear)) {
                    searchResult.carList.put(car.getVin(), car);
                }
            }
            searchResult.showCarList(searchResult);
            searchCarByYearRange();
        } else {
            return;
        }
    }

    public void searchCarByMileage() {
        CarList searchResult = new CarList();
        int lowerMileage, upperMileage;
        Scanner sc = new Scanner(System.in);
        System.out.println("Для поиска автомобиля по величине пробега введите показания одометра, с которых хотите начать фильтр (либо введите 0, чтобы вернуться в меню):");
        lowerMileage = sc.nextInt();
        if (lowerMileage != 0) {
            System.out.println("Теперь введите показания одометра, которыми хотите завершить фильтр:");
            upperMileage = sc.nextInt();
            for (String vin: carList.keySet()) {
                Car car = carList.get(vin);
                if (car.getMileage() >= lowerMileage && (car.getMileage() <= upperMileage)) {
                    searchResult.carList.put(car.getVin(),car);
                }
            }
            searchResult.showCarList(searchResult);
            searchCarByMileage();
        } else {
            return;
        }
    }

}