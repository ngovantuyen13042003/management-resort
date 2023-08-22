package svt.st.managementresot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import svt.st.managementresot.entity.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
