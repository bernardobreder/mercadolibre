import { render, screen } from "@testing-library/react";
import ProductMain from "../ProductMain";

describe("ProductMain", () => {
  it("deve renderizar nome, preço e botão", () => {
    render(<ProductMain nome="Samsung Galaxy A55" preco={439.0} />);
    expect(screen.getByText("Samsung Galaxy A55")).toBeInTheDocument();
    expect(screen.getByText("R$ 439")).toBeInTheDocument();
    expect(
      screen.getByRole("button", { name: /comprar agora/i })
    ).toBeInTheDocument();
  });
});
