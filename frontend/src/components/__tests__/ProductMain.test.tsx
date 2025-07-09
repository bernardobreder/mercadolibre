import { render, screen } from "@testing-library/react";
import ProductMain from "../ProductMain";

describe("ProductMain", () => {
  it("must render name, price, and button", () => {
    render(<ProductMain name="Samsung Galaxy A55" price={439.0} />);
    expect(screen.getByText("Samsung Galaxy A55")).toBeInTheDocument();
    expect(screen.getByText("R$ 439")).toBeInTheDocument();
    expect(
      screen.getByRole("button", { name: /comprar agora/i })
    ).toBeInTheDocument();
  });
});
