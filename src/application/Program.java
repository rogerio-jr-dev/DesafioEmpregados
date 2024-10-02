package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// import entities.Department;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String nameDepartement = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int payDay = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha que ficou após o nextInt()
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String phone = sc.nextLine();
        Address address = new Address(email,phone);
        Department department = new Department(nameDepartement, payDay, address);

        System.out.print("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();
        sc.nextLine(); // Consumir a quebra de linha que ficou após o nextInt()

        for (int i = 1; i <= n; i++) {
            System.out.printf("Dados do funcionário %d: \n", i);
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Salário: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // Consumir a quebra de linha que ficou após o nextDouble()
            // Criar uma nova instância de Employee para cada iteração
            Employee employee = new Employee(name, salary);
            department.addEmployee(employee); // Adiciona o novo funcionário ao departamento
        }
        System.out.println();
        System.out.println("FOLHA DE PAGAMENTO: ");
        showReport(department);

        sc.close();
    }

    private static void showReport(Department department) {
        StringBuilder sb = new StringBuilder();
        sb.append("Departamento Vendas = R$ " + String.format("%.2f", department.payRoll()) + "\n");
        sb.append("Pagamento realizado no dia " + department.getPayDay() + "\n");
        sb.append("Funcionários: \n");
        for (Employee emp : department.getEmployees()) {
            sb.append(emp.getName() + "\n");
        }
        sb.append("Para dúvidas favor entrar em contato: " + department.getAddress().getEmail());
        // Exibir o relatório
        System.out.println(sb.toString());
    }
}
