public class BankAccount {

  private double moneyOnCard = 0.0;

  public double getAmount() {
    //TODO: реализуйте метод и удалите todo
    // верните значение количества денег не счету
    return moneyOnCard;
  }

  public void put(double amountToPut) {
    //TODO: реализуйте метод и удалите todo
    // метод зачисляет деньги на счет
    if (amountToPut > 0) {
      moneyOnCard += amountToPut;
    }
  }

  public void take(double amountToTake) {
    //TODO: реализуйте метод и удалите todo
    // метод списывает деньги со счета
    if (amountToTake > 0 && amountToTake < moneyOnCard) {
      moneyOnCard -= amountToTake;
    }
  }
}
