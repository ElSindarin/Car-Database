import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        CarList carDataBase = new CarList();
        callMainMenu(carDataBase);
    }

    public static void callMainMenu (CarList carDataBase) {
        System.out.println("Добро пожаловать в меню по работе с базой данных автомобилей!");
        byte number = 0;
        Scanner sc = new Scanner(System.in);
        mainMenu: while (number != -1) {
            showMainMenuText();
            number = sc.nextByte();
            switch (number) {
                case 1: {
                    callSearchMenu(carDataBase);
                    break;
                }
                case 2: {
                    carDataBase.addCar();
                    break;
                }
                case 3: {
                    carDataBase.editCar();
                    break;
                }
                case 4: {
                    callDeleteMenu(carDataBase);
                    break;
                }
                case 0: {
                    continue mainMenu;
                }
                case -1: {
                    return;
                }
                default: {
                    System.out.println("Введённая вами опция не существует!");
                    break;
                }
            }
        }
    }

    public static void callSearchMenu(CarList carDataBase) {
        Scanner sc = new Scanner(System.in);
        byte number = 0;
               searchMenu: while (number != -1) {
            showSearchMenu();
            number = sc.nextByte();
            switch (number) {
                case 1: {
                    carDataBase.searchCarByVIN();
                    break;
                }
                case 2: {
                    carDataBase.searchCarByRegNum();
                    break;
                }
                case 3: {
                    carDataBase.searchCarByMarkAndModel();
                    break;
                }
                case 4: {
                    carDataBase.searchCarByYearRange();
                    break;
                }
                case 5: {
                    carDataBase.searchCarByMileage();
                    break;
                }
                case 7: {
                    carDataBase.showCarList(carDataBase);
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Выбранная вами опция не существует!");
                    break;
                }
            }
        }

    }

    public static void callDeleteMenu (CarList carDataBase) {
        Scanner sc = new Scanner(System.in);
        byte number = 0;
        searchMenu: while (number != -1) {
            showDeleteMenu();
            number = sc.nextByte();
            switch (number) {
                case 1: {
                    carDataBase.removeCar();
                    break;
                }
                case 2: {
                    carDataBase.removeByYear();
                    break;
                }
                case 3: {
                    carDataBase.removeAllCars();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Выбранная вами опция не существует!");
                    break;
                }
            }
        }

    }

    public static void showMainMenuText () {
        System.out.println("Выберите опцию и введите соответствующее число:");
        System.out.println("1 - Открыть меню поиска");
        System.out.println("2 - Внести автомобиль в базу данных");
        System.out.println("3 - Редактировать информацию об автомобиле по VIN-коду");
        System.out.println("4 - Открыть меню удаления информации");
        System.out.println("0 - Вернуться в предыдущее меню");
        System.out.println("-1 - Завершить программу");
    }

    public static void showSearchMenu () {
        System.out.println("Меню поиска:");
        System.out.println("1 - Поиск по VIN-коду автомобиля");
        System.out.println("2 - Поиск по регистрационному номеру автомобиля");
        System.out.println("3 - Поиск по марке и модели автомобиля");
        System.out.println("4 - Поиск по году выпуска автомобиля (от ... и до ... включительно)");
        System.out.println("5 - Поиск по величине пробега (от ... и до ... включительно)");
        System.out.println("7 - Отобразить список всех машин");
        System.out.println("0 - Вернуться в предыдущее меню");
    }

    public static void showDeleteMenu() {
        System.out.println("Меню удаления:");
        System.out.println("1 - Удаление автомобиля по VIN-коду");
        System.out.println("2 - Удаление автомобиля по году выпуска от ... и до ...");
        System.out.println("3 - Очистка всей базы данных автомобилей");
        System.out.println("0 - Вернуться в предыдущее меню");
    }
}
