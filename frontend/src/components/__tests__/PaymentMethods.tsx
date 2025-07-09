import { render, screen } from "@testing-library/react";
import PaymentMethods from "../PaymentMethods";

describe("PaymentMethods", () => {
  it("must display the payment methods", () => {
    render(<PaymentMethods />);
    expect(screen.getByText(/medios de pago/i)).toBeInTheDocument();
    expect(screen.getByText(/12 cuotas/i)).toBeInTheDocument();
  });
});
